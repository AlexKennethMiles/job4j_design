package ru.job4j.ood.isp;

import java.time.LocalDateTime;
import java.util.List;

public class Sensor implements DeviceFunctions {
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
        return List.of(0, 212, 155);
    }

    @Override
    public float getPressure() {
        return 101_325F;
    }
}
