package ru.job4j.ood.srp;

public class SimpleSaleGenerator implements SaleGenerator {
    @Override
    public float getSale(float price) {
        return price * 0.75F;
    }
}
