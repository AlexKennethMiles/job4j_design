package ru.job4j.io;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Analysis {
    public static void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            Map<String, String> map = new LinkedHashMap<>();
            String[] buf;
            String key = null;
            boolean flag = false;
            for (String read = in.readLine(); read != null; read = in.readLine()) {
                buf = read.split(" ");
                if (buf[0].equals("400") || buf[0].equals("500")) {
                    if (!flag) {
                        key = buf[1];
                        map.put(key, key);
                        flag = true;
                    } else {
                        map.put(key, buf[1]);
                    }
                } else {
                    if (flag) {
                        map.put(key, buf[1]);
                        flag = false;
                    }
                }
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                out.write(entry.getKey()
                        + ";"
                        + entry.getValue()
                        + ";"
                        + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String pathFrom = "./data/server.log";
        String pathTo = "./data/periods_of_idleness_server.csv";
        unavailable(pathFrom, pathTo);
    }
}
