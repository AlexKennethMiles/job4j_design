package ru.job4j.foodstore;

public class Warehouse extends AbstractStore {
    public static final float WAREHOUSE_TERM = 25F;

    @Override
    protected boolean accept(Food food) {
        float percent = calculateDate(food);
        if (percent > 0
                && percent < WAREHOUSE_TERM) {
            return products.add(food);
        }
        return false;
    }
}
