package ru.job4j.design.lsp;

public class PassengerCar implements Auto {
    public static final int SIZE = 1;

    @Override
    public int getSize() {
        return SIZE;
    }
}
