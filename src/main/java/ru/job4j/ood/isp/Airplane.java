package ru.job4j.ood.isp;

public class Airplane implements EngineFunctions {
    @Override
    public void fly() {
        System.out.println("The plane is flying...");
    }

    @Override
    public void ride() {
        System.out.println("The plane is moving...");
    }
}
