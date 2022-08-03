package ru.job4j.design.ocp;

public class BMV extends Car {
    @Override
    public String getModel() {
        return "BMV";
    }

    @Override
    public double getPrice() {
        return 25_000D;
    }
}
