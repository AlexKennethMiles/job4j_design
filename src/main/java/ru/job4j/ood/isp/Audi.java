package ru.job4j.ood.isp;

public class Audi implements Auto {
    @Override
    public float getBWMPrice() {
        throw new UnsupportedOperationException("Incorrect car!");
    }

    @Override
    public float getAudiPrice() {
        return 45;
    }

    @Override
    public float getMitsubishiPrice() {
        throw new UnsupportedOperationException("Incorrect car!");
    }
}
