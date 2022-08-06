package ru.job4j.foodstore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractStore implements Store {
    protected List<Food> products = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return products.add(food);
    }

    @Override
    public List<Food> findBy(Predicate predicate) {
        return products.stream().filter(predicate).toList();
    }

    protected abstract boolean accept(Food food);
}
