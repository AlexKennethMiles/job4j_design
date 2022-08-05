package ru.job4j.foodstore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Shop implements Store {
    public static final float WAREHOUSE_TERM = 25F;
    public static final float SHOP_SALE_TERM = 75F;
    public static final float TRASH_TERM = 100F;
    private List<Food> products = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        float percent = calculateDate(food);
        if (percent >= WAREHOUSE_TERM
                && percent <= SHOP_SALE_TERM) {
            return products.add(food);
        } else if (percent > SHOP_SALE_TERM
                && percent < TRASH_TERM) {
            food.setPrice(food.getPrice() * (food.getDiscount() / 100));
            return products.add(food);
        }
        return false;
    }

    @Override
    public List<Food> findBy(Predicate predicate) {
        return products.stream().filter(predicate).toList();
    }
}
