package ru.job4j.design.ocp;

public class Suzuki extends Car {
    @Override
    public String getModel() {
        return "Suzuki";
    }

    @Override
    public double getPrice() {
        return 18_500D;
    }
}
