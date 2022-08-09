package ru.job4j.design.lsp;

public class Truck implements Auto {
    private int size;

    public Truck(int size) {
        if (size <= PassengerCar.SIZE) {
            throw new IllegalArgumentException("Incorrect size value!");
        }
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

}
