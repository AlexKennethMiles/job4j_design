package ru.job4j.design.ocp;

public class DataCentre {
    public static void main(String[] args) {
        DataAnalysis dataAnalysis = new VeryBigDataAnalysis();
        dataAnalysis.analysis();
    }
}
