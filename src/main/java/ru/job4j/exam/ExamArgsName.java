package ru.job4j.exam;

import java.util.HashMap;
import java.util.Map;

public class ExamArgsName {
    private Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    public void parse(String[] args) {
        checkThatArgsIsNotNull(args);
        String[] rsl;
        for (String arg : args) {
            checkTemplatesCompliance(arg);
            rsl = arg.split("=");
            values.put(rsl[0], rsl[1]);
        }
    }

    public boolean checkTemplatesCompliance(String arg) {
        int cursor = arg.indexOf("=");
        if (cursor == -1 || !arg.startsWith("-")) {
            throw new IllegalArgumentException("Invalid key value pair. Usage -key=value.");
        }
        String key = arg.substring(0, cursor);
        String value = arg.substring(cursor + 1);
        if (key.isEmpty()
                || key.contains("=")
                || value.contains("=")
                || value.isEmpty()) {
            throw new IllegalArgumentException("Invalid key value pair. Usage -key=value.");
        }
        return true;
    }

    public boolean checkThatArgsIsNotNull(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Empty key value pair. Usage -key=value.");
        }
        return true;
    }

    public static ExamArgsName of(String[] args) {
        ExamArgsName names = new ExamArgsName();
        names.parse(args);
        return names;
    }
}
