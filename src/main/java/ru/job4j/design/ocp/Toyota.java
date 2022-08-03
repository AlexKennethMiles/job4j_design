package ru.job4j.design.ocp;

public class Toyota extends Car {
    @Override
    public String getModel() {
        return "Toyota";
    }

    @Override
    public double getPrice() {
        return 17_800D;
    }
}
