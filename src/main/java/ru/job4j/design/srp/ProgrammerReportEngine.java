package ru.job4j.design.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ProgrammerReportEngine implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    private Store store;

    public ProgrammerReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html><head><title>Отчёт для программистов</title><meta charset=\"utf-8\"></head>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<h1>").append(employee.getName()).append("</h1>")
                    .append("<p>").append(DATE_FORMAT.format(employee.getHired().getTime())).append("</p>")
                    .append("<p>").append(DATE_FORMAT.format(employee.getFired().getTime())).append("</p>")
                    .append("<p>").append(employee.getSalary()).append("</p>")
                    .append("<p>").append(System.lineSeparator()).append("</p>")
            .append("<hr>");
        }
        text.append("</html>");
        return text.toString();
    }
}
