package ru.job4j.ood.isp;

public class Motorcycle implements EngineFunctions {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("A motorcycle can't fly!");
    }

    @Override
    public void ride() {
        System.out.println("The motorcycle is moving...");
    }
}
