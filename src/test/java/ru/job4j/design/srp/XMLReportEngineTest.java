package ru.job4j.design.srp;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

class XMLReportEngineTest {
    @Test
    public void whenXMLGenerated() throws JAXBException {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        StringBuilder expect = null;
        try {
            expect = new StringBuilder()
                    .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                    .append("<employees>")
                    .append("<employees>")
                    .append("<fired>")
                    .append(DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) now))
                    .append("</fired>")
                    .append("<hired>")
                    .append(DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) now))
                    .append("</hired>")
                    .append("<name>Ivan</name>")
                    .append("<salary>100.0</salary>")
                    .append("</employees>")
                    .append("</employees>");
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        XMLReportEngine engine = new XMLReportEngine(store, context);
        assertThat(engine.generate(o -> true).replaceAll("\\n\\s*", ""))
                .isEqualTo(expect != null ? expect.toString() : null);
    }
}
