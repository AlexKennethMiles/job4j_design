package ru.job4j.design.lsp;

import java.util.List;
import java.util.function.Predicate;

public class ParkingForPassengerCars extends AbstractParkingSpace {
    public ParkingForPassengerCars(int numberOfParkingSpaces) {
        super(numberOfParkingSpaces);
    }

    @Override
    public boolean addCar(Auto auto) {
        return super.addCar(auto);
    }

    @Override
    public List<Auto> findBy(Predicate predicate) {
        return super.findBy(predicate);
    }

    @Override
    public boolean accept(Auto a) {
        int size = (int) Math.ceil(a.getSize());
        if (numberOfParkingSpaces >= size
                && (a.getSize() >= 1)) {
            numberOfParkingSpaces--;
            return addCar(a);
        }
        return false;
    }
}
