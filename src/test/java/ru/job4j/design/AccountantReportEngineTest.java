package ru.job4j.design;

import org.junit.jupiter.api.Test;
import ru.job4j.design.srp.*;
import ru.job4j.design.srp.AccountantReportEngine;
import ru.job4j.design.srp.Employee;
import ru.job4j.design.srp.MemStore;
import ru.job4j.design.srp.Report;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class AccountantReportEngineTest {
    @Test
    public void whenAccountantGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new AccountantReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(ReportEngine.DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(ReportEngine.DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary() * 36.1D).append("$").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }

}
