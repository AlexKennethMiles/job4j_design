package ru.job4j.foodstore;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    public void whenFishGoToWarehouse() {
        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        ControlQuality manager = new ControlQuality(List.of(
                warehouse,
                shop,
                trash
        ));
        Food fish = new Fish("Salmon",
                LocalDateTime.now().minusDays(66),
                LocalDateTime.now().plusDays(665),
                100F,
                75F
        );
        manager.manageFood(fish);
        assertThat(warehouse.findBy(el -> true)).isEqualTo(List.of(fish));
    }

    @Test
    public void whenMeatGoToShopFullPrice() {
        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        ControlQuality manager = new ControlQuality(List.of(
                warehouse,
                shop,
                trash
        ));
        Food meat = new Meat("Beef",
                LocalDateTime.now().minusDays(5),
                LocalDateTime.now().plusDays(4),
                200F,
                80F
        );
        manager.manageFood(meat);
        assertThat(shop.findBy(el -> true)).isEqualTo(List.of(meat));
    }

    @Test
    public void whenBunGoToShopWithDiscount() {
        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        ControlQuality manager = new ControlQuality(List.of(
                warehouse,
                shop,
                trash
        ));
        Food bun = new Bun("Pie",
                LocalDateTime.now().minusDays(11),
                LocalDateTime.now().plusDays(2),
                45F,
                50F
        );
        manager.manageFood(bun);
        Food bunDiscount = new Bun("Pie",
                LocalDateTime.now().minusDays(11),
                LocalDateTime.now().plusDays(2),
                22.5F,
                50F
        );
        assertThat(shop.findBy(el -> true)).isEqualTo(List.of(bunDiscount));
    }

    @Test
    public void whenMilkGoToTrash() {
        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        ControlQuality manager = new ControlQuality(List.of(
                warehouse,
                shop,
                trash
        ));
        Food milk = new Milk("Cow's milk",
                LocalDateTime.now().minusDays(18),
                LocalDateTime.now().minusDays(8),
                80F,
                65F
        );
        manager.manageFood(milk);
        assertThat(trash.findBy(el -> true)).isEqualTo(List.of(milk));
    }

    @Test
    public void whenVeryOldBunGoToTrash() {
        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        ControlQuality manager = new ControlQuality(List.of(
                warehouse,
                shop,
                trash
        ));
        Food bun = new Bun("Pie",
                LocalDateTime.now().minusDays(572),
                LocalDateTime.now().minusDays(561),
                45F,
                50F
        );
        manager.manageFood(bun);
        assertThat(trash.findBy(el -> true)).isEqualTo(List.of(bun));
    }

    @Test
    public void whenSeveralFoodItemGoToWarehouse() {
        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        ControlQuality manager = new ControlQuality(List.of(
                warehouse,
                shop,
                trash
        ));
        Food fish = new Fish("Salmon",
                LocalDateTime.now().minusDays(65),
                LocalDateTime.now().plusDays(667),
                100F,
                75F
        );
        Food meat = new Fish("Pork",
                LocalDateTime.now().minusDays(65),
                LocalDateTime.now().plusDays(1_032),
                85F,
                80F
        );
        manager.manageFood(fish);
        manager.manageFood(meat);
        assertThat(warehouse.findBy(el -> true)).isEqualTo(List.of(fish, meat));
    }

    @Test
    public void whenSeveralFoodItemGoToTrash() {
        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        ControlQuality manager = new ControlQuality(List.of(
                warehouse,
                shop,
                trash
        ));
        Food milk = new Milk("Cow's milk",
                LocalDateTime.now().minusDays(18),
                LocalDateTime.now().minusDays(8),
                80F,
                65F
        );
        Food bun = new Bun("Pie",
                LocalDateTime.now().minusDays(572),
                LocalDateTime.now().minusDays(561),
                45F,
                50F
        );
        manager.manageFood(milk);
        manager.manageFood(bun);
        assertThat(trash.findBy(el -> true)).isEqualTo(List.of(milk, bun));
    }

    @Test
    public void whenProductFromFuture() {
        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        ControlQuality manager = new ControlQuality(List.of(
                warehouse,
                shop,
                trash
        ));
        Food bun = new Bun("Pie",
                LocalDateTime.now().plusDays(158),
                LocalDateTime.now().plusDays(2_726),
                45F,
                50F
        );
        manager.manageFood(bun);
        assertThat(warehouse.findBy(el -> true)).isEqualTo(List.of());
        assertThat(shop.findBy(el -> true)).isEqualTo(List.of());
        assertThat(trash.findBy(el -> true)).isEqualTo(List.of());
    }

    @Test
    public void whenRestoreAllProducts() {
        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        ControlQuality manager = new ControlQuality(List.of(
                warehouse,
                shop,
                trash
        ));
        Food fish = new Fish("Trout",
                LocalDateTime.now().minusDays(7),
                LocalDateTime.now().plusDays(115),
                100F,
                75F
        );
        Food meat = new Meat("Beef",
                LocalDateTime.now().minusDays(21),
                LocalDateTime.now().plusDays(44),
                200F,
                80F
        );
        Food milk = new Meat("Cow's milk",
                LocalDateTime.now().minusDays(8),
                LocalDateTime.now().minusDays(1),
                80F,
                65F
        );
        manager.manageFood(fish);
        manager.manageFood(meat);
        manager.manageFood(milk);
        assertThat(warehouse.findBy(el -> true)).isEqualTo(List.of(fish));
        assertThat(shop.findBy(el -> true)).isEqualTo(List.of(meat));
        assertThat(trash.findBy(el -> true)).isEqualTo(List.of(milk));
        manager.resort();
        assertThat(warehouse.findBy(el -> true)).isEqualTo(List.of(fish));
        assertThat(shop.findBy(el -> true)).isEqualTo(List.of(meat));
        assertThat(trash.findBy(el -> true)).isEqualTo(List.of(milk));
    }

    @Test
    public void whenRestoreAllProductsButEmptyStorages() {
        AbstractStore warehouse = new Warehouse();
        AbstractStore shop = new Shop();
        AbstractStore trash = new Trash();
        ControlQuality manager = new ControlQuality(List.of(
                warehouse,
                shop,
                trash
        ));
        assertThat(warehouse.findBy(el -> true)).isEqualTo(List.of());
        assertThat(shop.findBy(el -> true)).isEqualTo(List.of());
        assertThat(trash.findBy(el -> true)).isEqualTo(List.of());
        manager.resort();
        assertThat(warehouse.findBy(el -> true)).isEqualTo(List.of());
        assertThat(shop.findBy(el -> true)).isEqualTo(List.of());
        assertThat(trash.findBy(el -> true)).isEqualTo(List.of());
    }
}
