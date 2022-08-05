package ru.job4j.foodstore;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {
    @Test
    public void whenFishGoToWarehouse() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        Food fish = new Fish("Salmon",
                LocalDateTime.of(2022, Month.JUNE, 1, 1, 1),
                LocalDateTime.of(2024, Month.JUNE, 1, 1, 1),
                100F,
                75F
        );
        manager.manageFood(fish);
        assertThat(manager.getStorages().get(0).findBy(el -> true)).isEqualTo(List.of(fish));
    }

    @Test
    public void whenMeatGoToShopFullPrice() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        Food meat = new Meat("Beef",
                LocalDateTime.of(2022, Month.AUGUST, 1, 1, 1),
                LocalDateTime.of(2022, Month.AUGUST, 10, 1, 1),
                200F,
                80F
        );
        manager.manageFood(meat);
        assertThat(manager.getStorages().get(1).findBy(el -> true)).isEqualTo(List.of(meat));
    }

    @Test
    public void whenBunGoToShopWithDiscount() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        Food bun = new Bun("Pie",
                LocalDateTime.of(2022, Month.JULY, 25, 1, 1),
                LocalDateTime.of(2022, Month.AUGUST, 7, 1, 1),
                45F,
                50F
        );
        manager.manageFood(bun);
        Food bunDiscount = new Bun("Pie",
                LocalDateTime.of(2022, Month.JULY, 25, 1, 1),
                LocalDateTime.of(2022, Month.AUGUST, 7, 1, 1),
                22.5F,
                50F
        );
        assertThat(manager.getStorages().get(1).findBy(el -> true)).isEqualTo(List.of(bunDiscount));
    }

    @Test
    public void whenMilkGoToTrash() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        Food milk = new Milk("Cow's milk",
                LocalDateTime.of(2022, Month.JULY, 18, 1, 1),
                LocalDateTime.of(2022, Month.JULY, 28, 1, 1),
                80F,
                65F
        );
        manager.manageFood(milk);
        assertThat(manager.getStorages().get(2).findBy(el -> true)).isEqualTo(List.of(milk));
    }

    @Test
    public void whenVeryOldBunGoToTrash() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        Food bun = new Bun("Pie",
                LocalDateTime.of(2021, Month.JANUARY, 10, 1, 1),
                LocalDateTime.of(2021, Month.JANUARY, 21, 1, 1),
                45F,
                50F
        );
        manager.manageFood(bun);
        assertThat(manager.getStorages().get(2).findBy(el -> true)).isEqualTo(List.of(bun));
    }

    @Test
    public void whenSeveralFoodItemGoToWarehouse() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        Food fish = new Fish("Salmon",
                LocalDateTime.of(2022, Month.JUNE, 1, 1, 1),
                LocalDateTime.of(2024, Month.JUNE, 1, 1, 1),
                100F,
                75F
        );
        Food meat = new Fish("Pork",
                LocalDateTime.of(2022, Month.JUNE, 1, 1, 1),
                LocalDateTime.of(2025, Month.JUNE, 1, 1, 1),
                85F,
                80F
        );
        manager.manageFood(fish);
        manager.manageFood(meat);
        assertThat(manager.getStorages().get(0).findBy(el -> true)).isEqualTo(List.of(fish, meat));
    }

    @Test
    public void whenSeveralFoodItemGoToTrash() {
        ControlQuality manager = new ControlQuality(List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        ));
        Food milk = new Milk("Cow's milk",
                LocalDateTime.of(2022, Month.JULY, 18, 1, 1),
                LocalDateTime.of(2022, Month.JULY, 28, 1, 1),
                80F,
                65F
        );
        Food bun = new Bun("Pie",
                LocalDateTime.of(2021, Month.JANUARY, 10, 1, 1),
                LocalDateTime.of(2021, Month.JANUARY, 21, 1, 1),
                45F,
                50F
        );
        manager.manageFood(milk);
        manager.manageFood(bun);
        assertThat(manager.getStorages().get(2).findBy(el -> true)).isEqualTo(List.of(milk, bun));
    }
}
