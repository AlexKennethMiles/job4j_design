package ru.job4j.design.ocp;

public class VeryBigDataAnalysis implements DataAnalysis {
    private BigDataAnalysis bigDataAnalysis = new BigDataAnalysis();

    @Override
    public void analysis() {
        bigDataAnalysis.analysis();
        System.out.println("Analyzing a HUGE amount of data...");
    }
}
