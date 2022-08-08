package ru.job4j.ood.dip;

import java.time.LocalDateTime;
import java.util.Objects;

public class LongTermProducts {
    private String name;
    private float price;
    private LocalDateTime created;
    private LocalDateTime expiryDate;

    public LongTermProducts(String name, float price, LocalDateTime created, LocalDateTime expiryDate) {
        this.name = name;
        this.price = price;
        this.created = created;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LongTermProducts that = (LongTermProducts) o;
        return Float.compare(that.price, price) == 0
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
