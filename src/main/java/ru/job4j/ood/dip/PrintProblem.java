package ru.job4j.ood.dip;

public class PrintProblem {
    private int a;

    public PrintProblem(int a) {
        this.a = a;
    }

    /**
     * Нарушение Dependency Inversion Principle — поведение более высокого уровня напрямую зависит
     * от реализации низкого уровня {@link System#out#printA()}.
     * Необходимо использовать промежуточную абстракцию, например {@link java.util.logging.Logger}.
     */
    public void printA() {
        System.out.println("The value of A is: " + a);
    }
}
