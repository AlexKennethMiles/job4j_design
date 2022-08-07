package ru.job4j.foodstore;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {
    private static final int WAREHOUSE = 0;
    private static final int SHOP = 1;
    private static final int TRASH = 2;

    @Test
    public void whenFishGoToWarehouse() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        Food fish = new Fish("Salmon",
                LocalDateTime.now().minusDays(66),
                LocalDateTime.now().plusDays(665),
                100F,
                75F
        );
        manager.manageFood(fish);
        assertThat(manager.getStorages().get(WAREHOUSE).findBy(el -> true)).isEqualTo(List.of(fish));
    }

    @Test
    public void whenMeatGoToShopFullPrice() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        Food meat = new Meat("Beef",
                LocalDateTime.now().minusDays(5),
                LocalDateTime.now().plusDays(4),
                200F,
                80F
        );
        manager.manageFood(meat);
        assertThat(manager.getStorages().get(SHOP).findBy(el -> true)).isEqualTo(List.of(meat));
    }

    @Test
    public void whenBunGoToShopWithDiscount() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
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
        assertThat(manager.getStorages().get(SHOP).findBy(el -> true)).isEqualTo(List.of(bunDiscount));
    }

    @Test
    public void whenMilkGoToTrash() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        Food milk = new Milk("Cow's milk",
                LocalDateTime.now().minusDays(18),
                LocalDateTime.now().minusDays(8),
                80F,
                65F
        );
        manager.manageFood(milk);
        assertThat(manager.getStorages().get(TRASH).findBy(el -> true)).isEqualTo(List.of(milk));
    }

    @Test
    public void whenVeryOldBunGoToTrash() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        Food bun = new Bun("Pie",
                LocalDateTime.now().minusDays(572),
                LocalDateTime.now().minusDays(561),
                45F,
                50F
        );
        manager.manageFood(bun);
        assertThat(manager.getStorages().get(TRASH).findBy(el -> true)).isEqualTo(List.of(bun));
    }

    @Test
    public void whenSeveralFoodItemGoToWarehouse() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
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
        assertThat(manager.getStorages().get(WAREHOUSE).findBy(el -> true)).isEqualTo(List.of(fish, meat));
    }

    @Test
    public void whenSeveralFoodItemGoToTrash() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
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
        assertThat(manager.getStorages().get(TRASH).findBy(el -> true)).isEqualTo(List.of(milk, bun));
    }

    @Test
    public void whenProductFromFuture() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        Food bun = new Bun("Pie",
                LocalDateTime.now().plusDays(158),
                LocalDateTime.now().plusDays(2_726),
                45F,
                50F
        );
        manager.manageFood(bun);
        assertThat(manager.getStorages().get(WAREHOUSE).findBy(el -> true)).isEqualTo(List.of());
        assertThat(manager.getStorages().get(SHOP).findBy(el -> true)).isEqualTo(List.of());
        assertThat(manager.getStorages().get(TRASH).findBy(el -> true)).isEqualTo(List.of());
    }
}
