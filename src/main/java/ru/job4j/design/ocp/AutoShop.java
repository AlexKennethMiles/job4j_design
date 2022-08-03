package ru.job4j.design.ocp;

import java.util.List;

public class AutoShop {
    private List<Car> garage = List.of(
            new BMV(),
            new Audi(),
            new Toyota(),
            new Suzuki(),
            new Mercedes()
            );
}
