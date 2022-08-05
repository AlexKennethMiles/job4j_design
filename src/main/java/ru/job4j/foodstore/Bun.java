package ru.job4j.foodstore;

import java.time.LocalDateTime;

public class Bun extends Food {
    public Bun(String name, LocalDateTime createDate, LocalDateTime expiryDate, float price, float discount) {
        super(name, createDate, expiryDate, price, discount);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public LocalDateTime getCreateDate() {
        return super.getCreateDate();
    }

    @Override
    public void setCreateDate(LocalDateTime createDate) {
        super.setCreateDate(createDate);
    }

    @Override
    public LocalDateTime getExpiryDate() {
        return super.getExpiryDate();
    }

    @Override
    public void setExpiryDate(LocalDateTime expiryDate) {
        super.setExpiryDate(expiryDate);
    }

    @Override
    public float getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(float price) {
        super.setPrice(price);
    }

    @Override
    public float getDiscount() {
        return super.getDiscount();
    }

    @Override
    public void setDiscount(float discount) {
        super.setDiscount(discount);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
