package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        DuplicatesVisitor search = new DuplicatesVisitor();
        finDuplicates(start, search).forEach(System.out::println);
    }

    public static List<List<String>> finDuplicates(Path start, DuplicatesVisitor search) throws IOException {
        List<List<String>> rsl = new ArrayList<>();
        Files.walkFileTree(start, search);
        for (Map.Entry<FileProperty, List<String>> entry : search.getFiles().entrySet()) {
            if (entry.getValue().size() > 1) {
                rsl.add(entry.getValue());
            }
        }
        return rsl;
    }
}
