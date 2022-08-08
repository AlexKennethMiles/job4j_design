package ru.job4j.ood.dip;

import java.util.List;

/**
 * Класс нарушает DIP — в полях класса используется жёсткая связь с конкретными реализациями.
 * Тогда как для соблюдения принципа инверсии зависимостей, необходимо использовать промежуточную
 * абстракцию, например, общий класс Food как в {@link ru.job4j.foodstore.Food}.
 */
public class Warehouse {
    private List<LongTermProducts> longTermProducts;
    private List<ShortTermProduct> shortTermProducts;

    public Warehouse(List<LongTermProducts> longTermProducts, List<ShortTermProduct> shortTermProducts) {
        this.longTermProducts = longTermProducts;
        this.shortTermProducts = shortTermProducts;
    }

    public List<LongTermProducts> getLongTermProducts() {
        return longTermProducts;
    }

    public void setLongTermProducts(List<LongTermProducts> longTermProducts) {
        this.longTermProducts = longTermProducts;
    }

    public List<ShortTermProduct> getShortTermProducts() {
        return shortTermProducts;
    }

    public void setShortTermProducts(List<ShortTermProduct> shortTermProducts) {
        this.shortTermProducts = shortTermProducts;
    }
}
