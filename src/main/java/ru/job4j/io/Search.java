package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        checkArgs(args);
        Path start = Paths.get(args[3]);
        Predicate<Path> predicate = p -> p.toFile().getName().endsWith(args[4]);
        search(start, predicate).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void checkArgs(String[] args) {
        if (args.length != 5
                || !args[0].equals("java")
                || !args[1].equals("-jar")
                || !args[2].endsWith(".jar")
                || !args[4].startsWith(".")) {
            throw new IllegalArgumentException(
                    "Incorrect set of program arguments. "
                            + "Usage java -jar target\\searchFiles.jar ROOT_PATH FILE_EXTENSION"
            );
        }
        if (!Paths.get(args[3]).toFile().exists()) {
            throw new IllegalArgumentException(
                    "There is no file in the source path."
                            + "Usage java -jar target\\searchFiles.jar ROOT_PATH FILE_EXTENSION"
            );
        }
    }
}
