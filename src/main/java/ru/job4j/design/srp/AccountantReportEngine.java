package ru.job4j.design.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

import static ru.job4j.design.srp.ReportEngine.DATE_FORMAT;

public class AccountantReportEngine implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
    public static final double RUR_TO_USD = 36.1D;

    private Store store;

    public AccountantReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary() * RUR_TO_USD).append("$").append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
