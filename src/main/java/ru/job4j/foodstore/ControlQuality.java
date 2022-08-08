package ru.job4j.foodstore;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private List<AbstractStore> storages;

    public ControlQuality(List<AbstractStore> storages) {
        this.storages = storages;
    }

    public List<AbstractStore> getStorages() {
        return new ArrayList<>(storages);
    }

    public void manageFood(Food food) {
        for (AbstractStore storage : storages) {
            if (storage.accept(food)) {
                break;
            }
        }
    }
}
