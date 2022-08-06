package ru.job4j.foodstore;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

public interface Store {
    boolean add(Food food);

    List<Food> findBy(Predicate predicate);

    default float calculateDate(Food food) {
        Duration fullPeriod = Duration.between(food.getCreateDate(), food.getExpiryDate());
        Duration actualPeriod = Duration.between(food.getCreateDate(), LocalDateTime.now());
        float full = (float) fullPeriod.toDays();
        float actual = (float) actualPeriod.toDays();
        return (actual / full) * 100;
    }
}
