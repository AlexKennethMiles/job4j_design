package ru.job4j.io;

import java.io.*;

public class Analysis {
    public static void unavailable(String source, String target) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            StringBuilder rsl = analysisAndRecording(source);
            out.write(rsl.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder analysisAndRecording(String source) {
        StringBuilder timePeriod = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String[] buf;
            boolean flag = false;
            for (String read = in.readLine(); read != null; read = in.readLine()) {
                buf = read.split(" ");
                if (buf[0].equals("400") || buf[0].equals("500")) {
                    if (!flag) {
                        timePeriod.append(buf[1]).append(";");
                        flag = true;
                    }
                } else {
                    if (flag) {
                        timePeriod.append(buf[1]).append(";").append(System.lineSeparator());
                        flag = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return timePeriod;
    }

    public static void main(String[] args) {
        String pathFrom = "./data/server.log";
        String pathTo = "./data/periods_of_idleness_server.csv";
        unavailable(pathFrom, pathTo);
    }
}
