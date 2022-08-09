package ru.job4j.design.lsp;


public class TruckParking extends AbstractParkingSpace {
    public TruckParking(int numberOfParkingSpaces) {
        super(numberOfParkingSpaces);
    }

    @Override
    public boolean accept(Auto a) {
        int size = a.getSize();
        return spaceCount > 0
                && size > 1;
    }
}
