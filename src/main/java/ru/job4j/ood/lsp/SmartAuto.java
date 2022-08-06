package ru.job4j.ood.lsp;

public class SmartAuto extends Auto {
    public SmartAuto(String engineType, float fuelReserve) {
        super(engineType, fuelReserve);
    }

    /**
     * В переопределённом методе добавлено дополнительное условие — на переменную родительского класса.
     * Принцип LSP нарушен!
     *
     * @param engineType  — от типа двигателя зависит заправляемое топливо (они должны совпадать)
     * @param fuelReserve — объём заправляемого топлива
     */
    @Override
    public void refuel(String engineType, float fuelReserve) {
        if (super.fuelReserve > 100) {
            super.refuel(engineType, fuelReserve);
        } else {
            super.refuel(engineType, 100);
        }
    }

    private void doSomething() {
        System.out.println("Wow, this is a very smart car!");
    }
}
