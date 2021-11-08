package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private List<String> answers = new ArrayList<>();
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
        readPhrases();
        Scanner command = new Scanner(System.in);
        List<String> rsl = new ArrayList<>();
        boolean flag = true;
        boolean isExit = false;
        String bufScanner;
        String bufBotAnswer;
        while (!isExit) {
            bufScanner = command.nextLine();
            rsl.add(bufScanner);
            if (OUT.equals(bufScanner)) {
                isExit = true;
                continue;
            }
            bufBotAnswer = answers.get((int) (Math.random() * answers.size()));
            if (flag) {
                if (STOP.equals(bufScanner)) {
                    flag = false;
                } else {
                    System.out.println(bufBotAnswer);
                    rsl.add(bufBotAnswer);
                }
            } else {
                if (CONTINUE.equals(bufScanner)) {
                    flag = true;
                    System.out.println(bufBotAnswer);
                    rsl.add(bufBotAnswer);
                }
            }
        }
        command.close();
        saveLog(rsl);
    }

    private List<String> readPhrases() {
        try (BufferedReader in = new BufferedReader(
                new FileReader(botAnswers, Charset.forName("Windows-1251")))) {
            in.lines().forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
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
