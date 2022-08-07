package ru.job4j.ood.isp;

public class BMW implements Auto {
    @Override
    public float getBWMPrice() {
        return 50;
    }

    @Override
    public float getAudiPrice() {
        throw new UnsupportedOperationException("Incorrect car!");
    }

    @Override
    public float getMitsubishiPrice() {
        throw new UnsupportedOperationException("Incorrect car!");
    }
}
