package ru.job4j.ood.dip;

public class DataAccess {
    private int data;

    public DataAccess(int data) {
        this.data = data;
    }

    public void connectToData() {
    }

    public int doSmthWithData() {
        return (data * data) + 5;
    }
}
