package ru.job4j.io;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws FileNotFoundException {
        checkArgs(argsName);
        File source = Paths.get(argsName.get("-source")).toFile();
        try (var scanner = new Scanner(source)) {
            List<List<String>> rows = new ArrayList<>();
            ArrayList<Integer> numberOfColumn = new ArrayList<>();
            List<String> headers = Arrays.asList(argsName.get("-filter").split(","));
            if (scanner.hasNextLine()) {
                rows.add(new ArrayList<>());
                String[] bufColumn = scanner.nextLine().split(argsName.get("-delimiter"));
                for (int i = 0; i < bufColumn.length; i++) {
                    if (headers.contains(bufColumn[i])) {
                        rows.get(0).add(bufColumn[i]);
                        numberOfColumn.add(i);
                    }
                }
                int rowCount = 1;
                while (scanner.hasNextLine()) {
                    bufColumn = scanner.nextLine().split(argsName.get("-delimiter"));
                    rows.add(new ArrayList<>());
                    for (Integer index : numberOfColumn) {
                        rows.get(rowCount).add(bufColumn[index]);
                    }
                    rowCount++;
                }
                outputRsl(argsName, rows);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkArgs(ArgsName argsName) throws FileNotFoundException {
        if (argsName.get("-filter").contains(argsName.get("-delimiter"))) {
            throw new IllegalArgumentException("The filter cannot contain delimiter");
        }
        if (!Paths.get(argsName.get("-source")).toFile().exists()) {
            throw new FileNotFoundException("Source file not found");
        }
        if (!Paths.get(argsName.get("-out")).toFile().exists()
                && !argsName.get("-out").contains("stdout")) {
            throw new IllegalArgumentException("Invalid value of -out. "
                    + "Enter the path to the file (-out=PATH) or output to the console (-out=stdout).");
        }
    }

    private static void outputRsl(ArgsName argsName, List<List<String>> rows) {
        if (argsName.get("-out").equals("stdout")) {
            for (List<String> row : rows) {
                for (int i = 0; i < row.size() - 1; i++) {
                    System.out.print(row.get(i) + ";");
                }
                System.out.println(row.get(row.size() - 1));
            }
        } else {
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
    }
}
