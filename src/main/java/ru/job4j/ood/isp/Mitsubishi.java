package ru.job4j.ood.isp;

public class Mitsubishi implements Auto {
    @Override
    public float getBWMPrice() {
        throw new UnsupportedOperationException("Incorrect car!");
    }

    @Override
    public float getAudiPrice() {
        throw new UnsupportedOperationException("Incorrect car!");
    }

    @Override
    public float getMitsubishiPrice() {
        return 40;
    }
}
