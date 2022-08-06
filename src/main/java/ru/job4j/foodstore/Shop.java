package ru.job4j.foodstore;

public class Shop extends AbstractStore {
    public static final float WAREHOUSE_TERM = 25F;
    public static final float SHOP_SALE_TERM = 75F;
    public static final float TRASH_TERM = 100F;

    @Override
    protected boolean accept(Food food) {
        float percent = calculateDate(food);
        if (percent >= WAREHOUSE_TERM
                && percent <= SHOP_SALE_TERM) {
            return products.add(food);
        } else if (percent > SHOP_SALE_TERM
                && percent < TRASH_TERM) {
            food.setPrice(food.getPrice() * (food.getDiscount() / 100));
            return products.add(food);
        }
        return false;
    }
}
