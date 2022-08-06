package ru.job4j.ood.lsp;

public class Client {
    private String name;
    private boolean status;
    private float waterMeter;

    public Client(String name, boolean status, float waterMeter) {
        this.name = name;
        this.status = status;
        this.waterMeter = waterMeter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getWaterMeter() {
        return waterMeter;
    }

    public void setWaterMeter(float waterMeter) {
        this.waterMeter = waterMeter;
    }
}
