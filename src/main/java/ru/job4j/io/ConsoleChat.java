package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "завершить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner command = new Scanner(System.in);
        boolean flag = true;
        String buf = command.nextLine();
        while (!buf.equals(OUT)) {
            if (flag) {
                if (buf.equals(STOP)) {
                    flag = false;
                } else {
                    System.out.println(botAnswers);
                }
            } else {
                if (buf.equals(CONTINUE)) {
                    flag = true;
                    System.out.println(botAnswers);
                }
            }
            buf = command.nextLine();
        }
        command.close();
    }

    private List<String> readPhrases() {
        List<String> readingRsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(
                new FileReader(botAnswers, Charset.forName("Windows-1251")))) {
            in.lines().forEach(readingRsl::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readingRsl;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(path, Charset.forName("Windows-1251")))) {
            log.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("consoleChatLog.txt", "Hello!");
        cc.run();
    }
}
