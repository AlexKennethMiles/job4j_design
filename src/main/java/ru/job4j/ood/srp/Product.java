package ru.job4j.ood.srp;

public class Product {
    private String name;
    private float price;
    private SaleGenerator saleGenerator;

    public Product(String name, float price, SaleGenerator saleGenerator) {
        this.name = name;
        this.price = price;
        this.saleGenerator = saleGenerator;
    }

    public String getName() {
        return name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return saleGenerator.getSale(price);
    }

    public void setSaleGenerator(SaleGenerator saleGenerator) {
        this.saleGenerator = saleGenerator;
    }
}
