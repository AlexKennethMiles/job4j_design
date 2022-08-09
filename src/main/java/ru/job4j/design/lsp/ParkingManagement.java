package ru.job4j.design.lsp;

import java.util.List;

public class ParkingManagement {
    private List<AbstractParkingSpace> parkingSpaces;

    public ParkingManagement(List<AbstractParkingSpace> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public void manageParkingPlaces(Auto auto) {
        for (AbstractParkingSpace parkingSpace : parkingSpaces) {
            if (parkingSpace.accept(auto)) {
                parkingSpace.addCar(auto);
                break;
            }
        }
    }

    public List<AbstractParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }
}
