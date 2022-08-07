package ru.job4j.ood.isp;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Нарушен Interface Segregation Principle — реализующие классы должны "глушить" неиспользуемые методы.
 * Решение — разделение на отдельные интерфейсы, например: TempFunction, GateFunction,
 * ColorFunction, PressureFunction. И затем реализовывать только те, что необходимы.
 */
public interface DeviceFunctions {
    float getTemp();

    LocalDateTime getDate();

    List<Integer> getColor();

    float getPressure();
}
