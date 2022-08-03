package ru.job4j.ood.srp;

import java.time.LocalDateTime;

public class DateTempCount implements DateCount, TempCount {
    @Override
    public LocalDateTime computingDate() {
        return LocalDateTime.now();
    }

    @Override
    public float computingTemperature() {
        return 25.4F;
    }
}
