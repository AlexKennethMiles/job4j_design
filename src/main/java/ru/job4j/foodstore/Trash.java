package ru.job4j.foodstore;

public class Trash extends AbstractStore {
    public static final float TRASH_TERM = 100F;

    @Override
    protected boolean accept(Food food) {
        if (calculateDate(food) >= TRASH_TERM) {
            return products.add(food);
        }
        return false;
    }
}
