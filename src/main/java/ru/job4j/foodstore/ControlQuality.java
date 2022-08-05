package ru.job4j.foodstore;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private List<Store> storages = new ArrayList<>();

    public ControlQuality(List<Store> storages) {
        this.storages = storages;
    }

    public List<Store> getStorages() {
        return storages;
    }

    public void manageFood(Food food) {
        for (Store storage : storages) {
            if (storage.add(food)) {
                break;
            }
        }
    }
}
