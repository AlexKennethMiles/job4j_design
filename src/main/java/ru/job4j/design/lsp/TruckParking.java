package ru.job4j.design.lsp;

import java.util.List;
import java.util.function.Predicate;

public class TruckParking extends AbstractParkingSpace {
    public TruckParking(int numberOfParkingSpaces) {
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
        if (numberOfParkingSpaces > 0
                && a.getSize() > 1) {
            numberOfParkingSpaces--;
            return addCar(a);
        }
        return false;
    }
}
