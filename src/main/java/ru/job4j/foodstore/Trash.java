package ru.job4j.foodstore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Trash implements Store {
    public static final float TRASH_TERM = 100F;
    private List<Food> products = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        if (calculateDate(food) >= TRASH_TERM) {
            return products.add(food);
        }
        return false;
    }

    @Override
    public List<Food> findBy(Predicate predicate) {
        return products.stream().filter(predicate).toList();
    }
}
