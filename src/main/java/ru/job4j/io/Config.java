package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (line.startsWith("#") || line.isEmpty()) {
                    continue;
                }
                int cursor = line.indexOf("=");
                if (cursor == -1) {
                    throw new IllegalArgumentException();
                }
                String key = line.substring(0, cursor);
                String value = line.substring(cursor + 1);
                if (key.isEmpty()
                        || key.contains("=")
                        || value.contains("=")) {
                    throw new IllegalArgumentException();
                }
                values.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        for (Map.Entry<String, String> entry : values.entrySet()) {
            if (entry.getKey().contains(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
