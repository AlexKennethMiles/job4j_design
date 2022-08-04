package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XMLReportEngine implements Report {
    private Store store;
    private JAXBContext context;
    private Marshaller marshaller;

    public XMLReportEngine(Store store, JAXBContext context) throws JAXBException {
        this.store = store;
        this.context = context;
        this.marshaller = context.createMarshaller();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(new Employees(store.findBy(filter)), writer);
                xml = writer.getBuffer().toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
