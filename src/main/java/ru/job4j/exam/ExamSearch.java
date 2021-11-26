package ru.job4j.exam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class ExamSearch {
    public static ExamArgsName checkAndParseArgs(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException(
                    "Incorrect set of program arguments. "
                            + "Usage java -jar find.jar -d=DIR -n=PartOfTheFile -t=MOD -o=TARGET."
            );
        }
        ExamArgsName argsName = new ExamArgsName();
        argsName.parse(args);
        if (!argsName.get("-t").equals("mask")
                && !argsName.get("-t").equals("name")
                && !argsName.get("-t").equals("regex")) {
            throw new IllegalArgumentException(
                    "Incorrect operation mode. "
                            + "Use one of them: mask, name, regex."
            );
        }
        if (!Paths.get(argsName.get("-d")).toFile().exists()) {
            throw new IllegalArgumentException(
                    "There is no file in the source path. "
                            + "Usage java -jar find.jar -d=DIR -n=PartOfTheFile -t=MOD -o=TARGET."
            );
        }
        return argsName;
    }

    /**
     * -d=c:/ -n=*.txt -t=mask -o=log.txt
     **/
    private static List<Path> search(ExamArgsName argsName) throws IOException {
        Predicate<Path> condition;
        if (argsName.get("-t").equals("name")) {
            condition = p -> p.toFile().getName().equals(argsName.get("-n"));
        } else if (argsName.get("-t").equals("mask")) {
            String mask = argsName.get("-n").replace("*", "");
            condition = p -> p.toFile().getName().endsWith(mask);
        } else {
            condition = p -> p.toFile().getName().matches(argsName.get("-n"));
        }
        ExamSearchFiles searcher = new ExamSearchFiles(condition);
        Files.walkFileTree(Paths.get(argsName.get("-d")), searcher);
        return searcher.getPaths();
    }

    private static void writeLog(ExamArgsName rslArgs, List<Path> searchRsl) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(rslArgs.get("-o")));
            for (Path path : searchRsl) {
                out.write(path.toString());
                out.newLine();
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * java -jar target/find.jar -d=. -n=.*.txt -t=regex -o=./data/log.txt
     **/
    public static void main(String[] args) throws IOException {
        ExamArgsName rslArgs = checkAndParseArgs(args);
        List<Path> searchRsl = search(rslArgs);
        writeLog(rslArgs, searchRsl);
    }
}
