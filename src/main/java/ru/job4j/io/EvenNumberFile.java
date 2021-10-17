package ru.job4j.io;

import java.io.FileInputStream;
import java.util.Scanner;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            Scanner scanner = new Scanner(in);
            StringBuilder text = new StringBuilder();
            while (scanner.hasNext()) {
                int num = scanner.nextInt();
                text.append(num).append(" % 2 == 0 = ");
                text.append(num % 2 == 0);
                text.append(System.lineSeparator());
            }
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
