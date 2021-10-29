package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
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
            values.put(rsl[0].substring(1), rsl[1]);
        }
    }

    public boolean checkTemplatesCompliance(String arg) {
        int cursor = arg.indexOf("=");
        if (cursor == -1 || !arg.startsWith("-")) {
            throw new IllegalArgumentException("Invalid key value pair. Usage -key=value.");
        }
        String key = arg.substring(1, cursor);
        String value = arg.substring(cursor + 1);
        if (key.isEmpty()
                || key.startsWith("-")
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

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
