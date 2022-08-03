package ru.job4j.ood.srp;

import java.time.LocalDateTime;

public class SimpleDateCount implements DateCount {
    @Override
    public LocalDateTime computingDate() {
        return LocalDateTime.now().plusYears(1);
    }
}
