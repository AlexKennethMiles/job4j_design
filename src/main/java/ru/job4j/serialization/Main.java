package ru.job4j.serialization;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        Field field = new Field(true,
                1000D,
                new Crop("Rice"),
                new String[]{"22.05.2021", "09.06.2021"}
        );
        JSONObject oldField = new JSONObject(field);
        System.out.println(oldField);

        String[] processingLog = {"16.06.2021", "20.08.2021"};
        JSONArray jsonProcessingLog = new JSONArray(processingLog);
        JSONObject crop = new JSONObject("{\"currCrop\":\"Wheat\"}");
        JSONObject newField = new JSONObject();
        newField.put("isProcessed", field.isProcessed());
        newField.put("square", field.getSquare());
        newField.put("title", crop);
        newField.put("processingLog", jsonProcessingLog);
        System.out.println(newField);
    }
}
