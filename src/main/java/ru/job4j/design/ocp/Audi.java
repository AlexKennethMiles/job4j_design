package ru.job4j.design.ocp;

public class Audi extends Car {
    @Override
    public String getModel() {
        return "Audi";
    }

    @Override
    public double getPrice() {
        return 20_000D;
    }
}
