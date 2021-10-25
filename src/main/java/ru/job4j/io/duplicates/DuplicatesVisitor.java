package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<String>> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        FileProperty key = new FileProperty(path.toFile().getName(), path.toFile().length());
        if (!files.containsKey(key)) {
            files.put(key, new ArrayList<>());
        }
        files.get(key).add(path.toAbsolutePath().toString());
        return FileVisitResult.CONTINUE;
    }

    public Map<FileProperty, List<String>> getFiles() {
        return files;
    }
}
