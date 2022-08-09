package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractParkingSpace {
    protected List<Auto> cars;
    protected int spaceCount;

    public AbstractParkingSpace(int spaceCount) {
        this.cars = new ArrayList<>(spaceCount);
        this.spaceCount = spaceCount;
    }

    public boolean addCar(Auto auto) {
        if (!accept(auto)) {
            return false;
        }
        spaceCount--;
        return cars.add(auto);
    }

    public List<Auto> findBy(Predicate predicate) {
        return cars.stream().filter(predicate).toList();
    }

    public abstract boolean accept(Auto a);
}

