package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not a directory %s", file.getAbsoluteFile()));
        }
        System.out.printf("Current file name: %s%n", file.getName());
        System.out.printf("Current file total size: %s bytes%n", file.length());
        System.out.println("=== Internal Folder ===");
        for (File subFile : file.listFiles()) {
            System.out.println(
                    "File name: "
                            + subFile.getName()
                            + " | Type: "
                            + (subFile.isDirectory() ? " dir" : " file")
                            + " | Size: "
                            + subFile.length()
                            + " bytes"
            );
        }
    }
}
