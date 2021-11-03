package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private final String targetPath;
    private final String botAnswers;
    private static final String OUT = "завершить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String targetPath, String botAnswers) {
        this.targetPath = targetPath;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner command = new Scanner(System.in);
        List<String> rsl = new ArrayList<>();
        List<String> answers = readPhrases();
        boolean flag = true;
        String bufScanner = command.nextLine();
        String bufBotAnswer = answers.get((int) (Math.random() * answers.size()));
        while (!bufScanner.equals(OUT)) {
            rsl.add(bufScanner);
            if (flag) {
                if (bufScanner.equals(STOP)) {
                    flag = false;
                } else {
                    System.out.println(bufBotAnswer);
                    rsl.add(bufBotAnswer);
                }
            } else {
                if (bufScanner.equals(CONTINUE)) {
                    flag = true;
                    System.out.println(bufBotAnswer);
                }
            }
            bufScanner = command.nextLine();
            bufBotAnswer = answers.get((int) (Math.random() * answers.size()));
        }
        rsl.add(bufScanner);
        command.close();
        saveLog(rsl);
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
                new FileWriter(targetPath, Charset.forName("Windows-1251")))) {
            log.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("consoleChatLog.txt", "./data/botPhrases.txt");
        cc.run();
    }
}
