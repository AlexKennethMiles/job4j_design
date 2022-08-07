package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractParkingSpace {
    protected List<Auto> cars;
    protected int numberOfParkingSpaces;

    public AbstractParkingSpace(int numberOfParkingSpaces) {
        this.cars = new ArrayList<>(numberOfParkingSpaces);
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }

    public boolean addCar(Auto auto) {
        return cars.add(auto);
    }

    public List<Auto> findBy(Predicate predicate) {
        return cars.stream().filter(predicate).toList();
    }

    public abstract boolean accept(Auto a);
}

