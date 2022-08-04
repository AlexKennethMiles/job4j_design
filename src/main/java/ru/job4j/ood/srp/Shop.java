package ru.job4j.ood.srp;

import java.util.List;

public class Shop {
    public static void main(String[] args) {
        List<Employee> workers = List.of(
                new Cashier(),
                new Janitor(),
                new Packer()
        );
        for (Employee worker : workers) {
            worker.work();
        }
    }
}
