package ru.job4j.ood.lsp;

import java.time.LocalDateTime;

public class Child {
    private String name;
    private LocalDateTime dayOfBirth;

    public Child(String name, LocalDateTime dayOfBirth) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDateTime dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    @Override
    public String toString() {
        return "Child{"
                + "name='" + name + '\''
                + ", dayOfBirth=" + dayOfBirth
                + '}';
    }
}
