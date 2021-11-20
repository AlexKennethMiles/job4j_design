package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(true,
                1000D,
                new Crop("Rice"),
                new String[]{"22.05.2021", "09.06.2021"}
        );
        Gson gson = new GsonBuilder().create();
        String fieldToJson = gson.toJson(field);
        System.out.println(fieldToJson);

        try (FileWriter fileWriter = new FileWriter("./data/testField.json")) {
            gson.toJson(field, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader("./data/testField.json")) {
            Field fieldFromJson = gson.fromJson(fileReader, Field.class);
            System.out.println(fieldFromJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
