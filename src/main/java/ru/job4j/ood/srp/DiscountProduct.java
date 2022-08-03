package ru.job4j.ood.srp;

import java.util.Objects;

public class DiscountProduct {
    private String name;
    private float price;
    private SaleGenerator saleGenerator;

    public DiscountProduct(String name, float price, SaleGenerator saleGenerator) {
        this.name = name;
        this.price = price;
        this.saleGenerator = saleGenerator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return saleGenerator.getSale(price);
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public SaleGenerator getSaleGenerator() {
        return saleGenerator;
    }

    public void setSaleGenerator(SaleGenerator saleGenerator) {
        this.saleGenerator = saleGenerator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiscountProduct that = (DiscountProduct) o;
        return Float.compare(that.price, price) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "DiscountProduct{"
                + "name='" + name + '\''
                + ", price=" + price
                + ", saleGenerator=" + saleGenerator
                + '}';
    }
}
