package ru.job4j.design.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.design.srp.ReportEngine.DATE_FORMAT;

class HRReportEngineTest {
    @Test
    public void whenHRReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee a = new Employee("Ivan", now, now, 100);
        Employee b = new Employee("Dmitriy", now, now, 50);
        Employee c = new Employee("Alexey", now, now, 80);
        Employee d = new Employee("Petr", now, now, 500);
        store.add(a);
        store.add(b);
        store.add(c);
        store.add(d);
        Report engine = new HRReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(d.getName()).append(";")
                .append(d.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(a.getName()).append(";")
                .append(a.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(c.getName()).append(";")
                .append(c.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(b.getName()).append(";")
                .append(b.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}
