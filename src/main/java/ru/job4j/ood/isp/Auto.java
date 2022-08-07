package ru.job4j.ood.isp;

/**
 * Интерфейс создаёт контракт на реализацию методов, заточенных под конкретные реализации.
 * Нарушен Interface Segregation Principle — реализующие классы должны "глушить" неиспользуемые методы.
 * Решение — разделение на отдельные интерфейсы, например: BWMPrice, AudiPrice, MitsubishiPrice.
 */
public interface Auto {
    float getBWMPrice();

    float getAudiPrice();

    float getMitsubishiPrice();
}
