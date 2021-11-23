package ru.job4j.serialization;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "field")
@XmlAccessorType(XmlAccessType.FIELD)
public class Field {
    @XmlAttribute
    private boolean isProcessed;
    @XmlAttribute
    private double square;
    @XmlElement
    private Crop currCrop;
    @XmlElementWrapper(name = "processingLogs")
    @XmlElement(name = "processingLog")
    private String[] processingLog;

    public Field() {
    }

    public Field(boolean isProcessed, double square, Crop currCrop, String[] processingLog) {
        this.isProcessed = isProcessed;
        this.square = square;
        this.currCrop = currCrop;
        this.processingLog = processingLog;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public double getSquare() {
        return square;
    }

    public Crop getCurrCrop() {
        return currCrop;
    }

    public String[] getProcessingLog() {
        return processingLog;
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
