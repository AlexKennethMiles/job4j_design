package ru.job4j.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class ExamSearch {
    public static void main(String[] args) throws IOException {
        checkArgs(args);
        Path start = Paths.get(args[3]);
        Predicate<Path> predicate = p -> p.toFile().getName().endsWith(args[4]);
//        search(start, predicate).forEach(System.out::println);
    }

//    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
//        ExSearchFiles searcher = new ExSearchFiles(condition);
//        Files.walkFileTree(root, searcher);
//        return searcher.getPaths();
//    }

    public static void checkArgs(String[] args) {
        if (args.length != 7
                || !args[0].equals("java")
                || !args[1].equals("-jar")
                || !args[2].endsWith(".jar")
                || !args[6].contains(".")) {
            throw new IllegalArgumentException(
                    "Incorrect set of program arguments. "
                            + "Usage java -jar find.jar -d=DIR -n=PartOfTheFile -t=MOD -o=TARGET"
            );
        }
        if (!args[5].equals("mask")
                && !args[5].equals("name")
                && !args[5].equals("regex")) {
            throw new IllegalArgumentException(
                    "Incorrect operation mode."
                            + "Use one of them: mask, name, regex."
            );
        }
        if (!Paths.get(args[3]).toFile().exists()) {
            throw new IllegalArgumentException(
                    "There is no file in the source path."
                            + "Usage java -jar searchFiles.jar ROOT_PATH FILE_EXTENSION"
            );
        }
    }
}
