package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DescSalaryOrder {
    public List<Employee> sortByDescSalary(List<Employee> workers, Comparator<Employee> comp) {
        return workers.stream().sorted(comp).collect(Collectors.toList());
    }
}
