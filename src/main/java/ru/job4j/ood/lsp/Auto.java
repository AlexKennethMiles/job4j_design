package ru.job4j.ood.lsp;

public class Auto {
    protected String engineType;
    protected float fuelReserve;

    public Auto(String engineType, float fuelReserve) {
        this.engineType = engineType;
        this.fuelReserve = fuelReserve;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public float getFuelReserve() {
        return fuelReserve;
    }

    public void setFuelReserve(float fuelReserve) {
        this.fuelReserve = fuelReserve;
    }

    public void refuel(String engineType, float fuelReserve) {
        if (this.engineType.equals(engineType)) {
            this.fuelReserve += fuelReserve;
        } else {
            throw new IllegalArgumentException("!!! Wrong engine type for this fuel !!!");
        }
    }
}
