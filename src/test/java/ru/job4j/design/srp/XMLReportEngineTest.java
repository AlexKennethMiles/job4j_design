package ru.job4j.design.srp;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

class XMLReportEngineTest {
    @Disabled
    @Test
    public void whenXMLGenerated() {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        StringBuilder expect = null;
        try {
            expect = new StringBuilder()
                    .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                    .append("\n")
                    .append("<employees>")
                    .append(System.lineSeparator())
                    .append("    <employees>")
                    .append(System.lineSeparator())
                    .append("        <fired>"
                            + DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) now)
                            + "</fired>")
                    .append(System.lineSeparator())
                    .append("        <hired>"
                            + DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) now)
                            + "</hired>")
                    .append(System.lineSeparator())
                    .append("        <name>Ivan</name>")
                    .append(System.lineSeparator())
                    .append("        <salary>100.0</salary>")
                    .append(System.lineSeparator())
                    .append("    </employees>")
                    .append(System.lineSeparator())
                    .append("</employees>")
                    .append(System.lineSeparator());
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        XMLReportEngine engine = new XMLReportEngine(store);
        assertThat(engine.generate(o -> true)).isEqualTo(expect.toString());
    }
}
