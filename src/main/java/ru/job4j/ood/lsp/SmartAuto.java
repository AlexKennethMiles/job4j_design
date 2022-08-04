package ru.job4j.ood.lsp;

public class SmartAuto extends Auto {
    public SmartAuto(String engineType, float fuelReserve) {
        super(engineType, fuelReserve);
    }

    @Override
    public void refuel(String engineType, float fuelReserve) {
        doSomething();
        super.refuel(engineType, fuelReserve);
    }

    private void doSomething() {
        System.out.println("Wow, this is a very smart car!");
    }
}
