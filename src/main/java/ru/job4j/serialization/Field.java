package ru.job4j.serialization;

import java.util.Arrays;

public class Field {
    private boolean isProcessed;
    private double square;
    private Crop currCrop;
    private String[] processingLog;

    public Field(boolean isProcessed, double square, Crop currCrop, String[] processingLog) {
        this.isProcessed = isProcessed;
        this.square = square;
        this.currCrop = currCrop;
        this.processingLog = processingLog;
    }

    @Override
    public String toString() {
        return "Field{"
                + "isProcessed=" + isProcessed
                + ",square=" + square
                + ",currCrop=" + currCrop
                + ",processingLog=" + Arrays.toString(processingLog)
                + '}';
    }
}
