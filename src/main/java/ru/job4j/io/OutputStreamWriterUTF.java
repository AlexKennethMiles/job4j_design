package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OutputStreamWriterUTF {
    private static String filePath = "./data/testUTF16.txt";

    public static void main(String[] args) throws IOException {
        System.out.println("=== Write UTF-16 file ===");
        writeUTF16CharacterStream();

        System.out.println("=== Read UTF-16 file ===");
        readUTF16FileAsBinaryStream();
    }

    public static void writeUTF16CharacterStream() throws IOException {
        File file = new File(filePath);
        OutputStream os = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_16);
        String str = "Japan-日本; China-中国";
        osw.write(str);
        osw.close();
    }

    public static void readUTF16FileAsBinaryStream() throws IOException {
        InputStream is = new FileInputStream(filePath);
        int byteValue;
        while ((byteValue = is.read()) != -1) {
            System.out.println((char) byteValue + " " + byteValue);
        }
    }
}
