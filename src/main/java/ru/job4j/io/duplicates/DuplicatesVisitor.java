package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<Path> uniqueFiles = new HashSet<>();
    private List<Path> duplicates = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        if (!uniqueFiles.add(path)) {
            duplicates.add(path);
        }
        return FileVisitResult.CONTINUE;
    }

    public Set<Path> getUniqueFiles() {
        return uniqueFiles;
    }

    public List<Path> getDuplicates() {
        return duplicates;
    }
}
