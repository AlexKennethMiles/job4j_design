package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        Field field = new Field(true,
                1000D,
                new Crop("Rice"),
                new String[]{"22.05.2021", "09.06.2021"}
        );

        JAXBContext context = JAXBContext.newInstance(Field.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(field, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Field result = (Field) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
