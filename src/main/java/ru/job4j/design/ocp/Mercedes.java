package ru.job4j.design.ocp;

public class Mercedes extends Car {
    @Override
    public String getModel() {
        return "Mercedes";
    }

    @Override
    public double getPrice() {
        return 30_000D;
    }
}
