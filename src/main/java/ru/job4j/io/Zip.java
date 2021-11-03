package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private ArgsName pairs = new ArgsName();

    public static void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(in.readAllBytes());
                }
                zip.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(in.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void commandParsing(String[] args) {
        if (args.length != 6
                || !args[0].equals("java")
                || !args[1].equals("-jar")
                || !args[2].endsWith(".jar")) {
            throw new IllegalArgumentException(
                    "Incorrect set of program arguments. "
                            + "Usage java -jar pack.jar -d=CATALOG_NAME\\SOURCE -e=EXCLUDED_EXTENSION -o=TARGET"
            );
        }
        String[] buf = {args[3], args[4], args[5]};
        pairs.parse(buf);
        File file = Paths.get(pairs.get("-d")).toFile();
        if (!file.exists()) {
            throw new IllegalArgumentException(
                    "There is no file in the source path. "
                            + "Usage java -jar pack.jar -d=job4j_design\\SOURCE -e=EXCLUDED_EXTENSION -o=TARGET"
            );
        }
    }

    public List<File> searchAndFilterFiles(String source) throws IOException {
        Path path = Path.of(source);
        Predicate<Path> predicate = p -> !p.toFile().getName().endsWith(pairs.get("-e"));
        return Search.search(path, predicate).stream()
                .map(Path::toFile)
                .collect(Collectors.toList());
    }

    /* java -jar pack.jar -d=./src -e=class -o=src.zip */
    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.commandParsing(args);
        List<File> foundFiles = zip.searchAndFilterFiles(zip.pairs.get("-d"));
        packFiles(foundFiles, new File(zip.pairs.get("-o")));
    }
}
