package ru.job4j.serialization;

public class Crop {
    private String title;

    public Crop(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Crop{"
                + "title='" + title + '\''
                + '}';
    }
}
