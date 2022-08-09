package ru.job4j.design.lsp;


public class ParkingForPassengerCars extends AbstractParkingSpace {
    public ParkingForPassengerCars(int numberOfParkingSpaces) {
        super(numberOfParkingSpaces);
    }

    @Override
    public boolean accept(Auto a) {
        int size = a.getSize();
        return spaceCount >= size
                && size >= 1;
    }
}
