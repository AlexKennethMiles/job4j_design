package ru.job4j.io;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) {
        File source = Paths.get(argsName.get("-path")).toFile();
        try (var scanner = new Scanner(source)) {
            List<List<String>> rows = new ArrayList<>();
            ArrayList<Integer> numberOfColumn = new ArrayList<>();
            List<String> headers = Arrays.asList(argsName.get("-filter").split(","));
            if (scanner.hasNextLine()) {
                rows.add(new ArrayList<>());
                String[] bufColumn = scanner.nextLine().split(";");
                for (int i = 0; i < bufColumn.length; i++) {
                    if (headers.contains(bufColumn[i])) {
                        rows.get(0).add(bufColumn[i]);
                        numberOfColumn.add(i);
                    }
                }
                int rowCount = 1;
                while (scanner.hasNextLine()) {
                    bufColumn = scanner.nextLine().split(";");
                    rows.add(new ArrayList<>());
                    for (int i = 0; i < bufColumn.length; i++) {
                        if (numberOfColumn.contains(i)) {
                            rows.get(rowCount).add(bufColumn[i]);
                        }
                    }
                    rowCount++;
                }
                try (PrintWriter out = new PrintWriter(argsName.get("-out"))) {
                    for (List<String> row : rows) {
                        for (int i = 0; i < row.size() - 1; i++) {
                            out.print(row.get(i) + ";");
                        }
                        out.println(row.get(row.size() - 1));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
