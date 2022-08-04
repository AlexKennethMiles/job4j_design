package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class JSONReportEngine implements Report {
    private Store store;

    public JSONReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return new GsonBuilder().create().toJson(store.findBy(filter));
    }
}
