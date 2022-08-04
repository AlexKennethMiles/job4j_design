package ru.job4j.design.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class JSONReportEngineTest {
    @Test
    public void whenJSONGenerated() {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        StringBuilder expect = new StringBuilder().append("[")
                .append("{\"name\":\"").append(worker.getName())
                .append("\",\"hired\":{\"year\":").append(now.get(Calendar.YEAR))
                .append(",\"month\":").append(now.get(Calendar.MONTH))
                .append(",\"dayOfMonth\":").append(now.get(Calendar.DAY_OF_MONTH))
                .append(",\"hourOfDay\":").append(now.get(Calendar.HOUR_OF_DAY))
                .append(",\"minute\":").append(now.get(Calendar.MINUTE))
                .append(",\"second\":").append(now.get(Calendar.SECOND))
                .append("},\"fired\":{\"year\":").append(now.get(Calendar.YEAR))
                .append(",\"month\":").append(now.get(Calendar.MONTH))
                .append(",\"dayOfMonth\":").append(now.get(Calendar.DAY_OF_MONTH))
                .append(",\"hourOfDay\":").append(now.get(Calendar.HOUR_OF_DAY))
                .append(",\"minute\":").append(now.get(Calendar.MINUTE))
                .append(",\"second\":").append(now.get(Calendar.SECOND))
                .append("},\"salary\":").append(worker.getSalary())
                .append("}]");
        JSONReportEngine engine = new JSONReportEngine(store);
        assertThat(engine.generate(o -> true)).isEqualTo(expect.toString());
    }
}
