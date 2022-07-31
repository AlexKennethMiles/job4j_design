package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findElement(value, (first, second) -> comparator.compare(first, second) <= 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findElement(value, (first, second) -> comparator.compare(first, second) >= 0);
    }

    public <T> T findElement(List<T> value, BiPredicate<T, T> predicate) {
        T element = value.get(0);
        for (T t : value) {
            if (predicate.test(element, t)) {
                element = t;
            }
        }
        return element;
    }
}
