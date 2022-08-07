package ru.job4j.ood.isp;

import java.time.LocalDateTime;
import java.util.List;

public class Thermometer implements DeviceFunctions {
    @Override
    public float getTemp() {
        return 36.5F;
    }

    @Override
    public LocalDateTime getDate() {
        throw new UnsupportedOperationException("The function is not supported!");
    }

    @Override
    public List<Integer> getColor() {
        throw new UnsupportedOperationException("The function is not supported!");
    }

    @Override
    public float getPressure() {
        throw new UnsupportedOperationException("The function is not supported!");
    }
}
