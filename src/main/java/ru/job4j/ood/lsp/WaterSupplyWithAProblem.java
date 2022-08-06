package ru.job4j.ood.lsp;

public class WaterSupplyWithAProblem extends WaterSupply {
    public WaterSupplyWithAProblem(Client client) {
        super(client);
    }

    /**
     * Нарушено постусловие — нет проверки на статус (активен/неактивен) клиента.
     * Поведение изменено через снятие условия при переопределении метода класса-родителя.
     * Результат: нарушение Liskov Substitution Principle.
     *
     * @param volumeOfWater — объём перекаченной воды
     */

    @Override
    public void pumpWater(float volumeOfWater) {
        client.setWaterMeter(volumeOfWater);
    }
}
