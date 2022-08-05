package ru.job4j.foodstore;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.function.Predicate;

public interface Store {
    boolean add(Food food);

    List<Food> findBy(Predicate predicate);

    default float calculateDate(Food food) {
        Duration fullPeriod = Duration.between(food.getCreateDate(), food.getExpiryDate());
        Duration actualPeriod = Duration.between(food.getCreateDate(),
                LocalDateTime.of(2022, Month.AUGUST, 5, 0, 0)
        );
        float full = (float) fullPeriod.toDays();
        float actual = (float) actualPeriod.toDays();
        if (actual < 0) {
            return 100F;
        }
        return (actual / full) * 100;
    }
}
