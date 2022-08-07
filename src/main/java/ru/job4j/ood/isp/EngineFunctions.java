package ru.job4j.ood.isp;

/**
 * Нарушен Interface Segregation Principle — реализующие классы должны "глушить" неиспользуемые методы.
 * Решение — разделение на отдельные интерфейсы, например: FlyFunction, RideFunction.
 * И затем реализовывать только те, что необходимы.
 */
public interface EngineFunctions {
    void fly();

    void ride();
}
