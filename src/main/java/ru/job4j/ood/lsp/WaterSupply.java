package ru.job4j.ood.lsp;

public class WaterSupply {
    protected Client client;

    public WaterSupply(Client client) {
        this.client = client;
    }

    public void pumpWater(float volumeOfWater) {
        if (client.isStatus()) {
            client.setWaterMeter(volumeOfWater);
        }
    }
}

