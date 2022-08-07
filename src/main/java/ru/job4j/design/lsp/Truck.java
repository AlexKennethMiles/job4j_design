package ru.job4j.design.lsp;

public class Truck implements Auto {
    private float size;

    public Truck(float size) {
        this.size = size;
    }

    @Override
    public float getSize() {
        return size;
    }

}
