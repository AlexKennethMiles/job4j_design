package ru.job4j.ood.isp;

import java.time.LocalDateTime;
import java.util.List;

public class Smartphone implements DeviceFunctions {
    @Override
    public float getTemp() {
        return 25.5F;
    }

    @Override
    public LocalDateTime getDate() {
        return LocalDateTime.now();
    }

    @Override
    public List<Integer> getColor() {
        return List.of(0, 65, 106);
    }

    @Override
    public float getPressure() {
        throw new UnsupportedOperationException("The function is not supported!");
    }
}
