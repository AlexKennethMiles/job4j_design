package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        DuplicatesVisitor search = new DuplicatesVisitor();
        Files.walkFileTree(start, search);
        for (Path uniqueFile : search.getDuplicates()) {
            System.out.println(uniqueFile);
        }
    }
}
