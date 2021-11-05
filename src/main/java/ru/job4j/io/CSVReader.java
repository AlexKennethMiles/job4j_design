package ru.job4j.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        File source = Paths.get(argsName.get("-path")).toFile();
        var scanner = new Scanner(source);
        StringBuilder rsl = new StringBuilder();
        ArrayList<Integer> numberOfColumn = new ArrayList<>();
        List<String> headers = Arrays.asList(argsName.get("-filter").split(","));
        if (scanner.hasNextLine()) {
            String[] bufColumn = scanner.nextLine().split(";");
            for (int i = 0; i < bufColumn.length; i++) {
                if (headers.contains(bufColumn[i])) {
                    rsl.append(bufColumn[i]).append(";");
                    numberOfColumn.add(i);
                }
            }
            rsl.append(System.lineSeparator());
            while (scanner.hasNextLine()) {
                bufColumn = scanner.nextLine().split(";");
                for (int i = 0; i < bufColumn.length; i++) {
                    if (numberOfColumn.contains(i)) {
                        rsl.append(bufColumn[i]).append(";");
                    }
                }
                rsl.append(System.lineSeparator());
            }
            System.out.println(rsl);
        }
    }
}
