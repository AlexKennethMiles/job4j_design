package ru.job4j.design.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.design.srp.ReportEngine.DATE_FORMAT;

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
                .append("<p>").append(DATE_FORMAT.format(worker.getHired().getTime())).append("</p>")
                .append("<p>").append(DATE_FORMAT.format(worker.getFired().getTime())).append("</p>")
                .append("<p>").append(worker.getSalary()).append("</p>")
                .append("<p>").append(System.lineSeparator()).append("</p>")
                .append("<hr>")
                .append("</html>");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}
