package ru.job4j.design;

import org.junit.jupiter.api.Test;
import ru.job4j.design.srp.*;
import ru.job4j.design.srp.Employee;
import ru.job4j.design.srp.MemStore;
import ru.job4j.design.srp.ProgrammerReportEngine;
import ru.job4j.design.srp.Report;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ProgrammerReportEngineTest {
    @Test
    public void whenProgrammerReportGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ProgrammerReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("<html><head><title>Отчёт для программистов</title><meta charset=\"utf-8\"></head>")
                .append("<h1>").append(worker.getName()).append("</h1>")
                .append("<p>").append(ReportEngine.DATE_FORMAT.format(worker.getHired().getTime())).append("</p>")
                .append("<p>").append(ReportEngine.DATE_FORMAT.format(worker.getFired().getTime())).append("</p>")
                .append("<p>").append(worker.getSalary()).append("</p>")
                .append("<p>").append(System.lineSeparator()).append("</p>")
                .append("<hr>")
                .append("</html>");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}
