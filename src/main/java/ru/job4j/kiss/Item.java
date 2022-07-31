package ru.job4j.kiss;

import java.util.Objects;

public class Item {
    private int price;
    private int count;

    public Item(int price, int count) {
        this.price = price;
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return price == item.price
                && count == item.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, count);
    }

    @Override
    public String toString() {
        return "Item{"
                + "price=" + price
                + ", count=" + count
                + '}';
    }
}
