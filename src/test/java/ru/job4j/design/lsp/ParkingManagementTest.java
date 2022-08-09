package ru.job4j.design.lsp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingManagementTest {
    private static final int TRUCK_PLACES = 0;
    private static final int PASSENGER_CAR_PLACES = 1;

    @Test
    public void whenOnePassengerCarGoToPassengerCarPlace() {
        Auto car = new PassengerCar();
        ParkingManagement parkingManagement = new ParkingManagement(
                List.of(
                        new TruckParking(0),
                        new ParkingForPassengerCars(1)
                )
        );
        parkingManagement.manageParkingPlaces(car);
        assertThat(parkingManagement.getParkingSpaces().get(TRUCK_PLACES).findBy(e -> true))
                .isEqualTo(List.of());
        assertThat(parkingManagement.getParkingSpaces().get(PASSENGER_CAR_PLACES).findBy(e -> true))
                .isEqualTo(List.of(car));
    }

    @Test
    public void whenOnePassengerCarDoNotGoToAnyPlace() {
        Auto car = new PassengerCar();
        ParkingManagement parkingManagement = new ParkingManagement(
                List.of(
                        new TruckParking(3),
                        new ParkingForPassengerCars(0)
                )
        );
        parkingManagement.manageParkingPlaces(car);
        assertThat(parkingManagement.getParkingSpaces().get(TRUCK_PLACES).findBy(e -> true))
                .isEqualTo(List.of());
        assertThat(parkingManagement.getParkingSpaces().get(PASSENGER_CAR_PLACES).findBy(e -> true))
                .isEqualTo(List.of());
    }

    @Test
    public void whenOnePassengerCarAndTruckGoToPassengerCarPlace() {
        Auto car = new PassengerCar();
        Auto truck = new Truck(2);
        ParkingManagement parkingManagement = new ParkingManagement(
                List.of(
                        new TruckParking(0),
                        new ParkingForPassengerCars(3)
                )
        );
        parkingManagement.manageParkingPlaces(car);
        parkingManagement.manageParkingPlaces(truck);
        assertThat(parkingManagement.getParkingSpaces().get(TRUCK_PLACES).findBy(e -> true))
                .isEqualTo(List.of());
        assertThat(parkingManagement.getParkingSpaces().get(PASSENGER_CAR_PLACES).findBy(e -> true))
                .isEqualTo(List.of(car, truck));
    }

    @Test
    public void whenOnlyOnePassengerCarGoToPassengerCarPlace() {
        Auto car = new PassengerCar();
        Auto truck = new Truck(2);
        ParkingManagement parkingManagement = new ParkingManagement(
                List.of(
                        new TruckParking(0),
                        new ParkingForPassengerCars(2)
                )
        );
        parkingManagement.manageParkingPlaces(car);
        parkingManagement.manageParkingPlaces(truck);
        assertThat(parkingManagement.getParkingSpaces().get(TRUCK_PLACES).findBy(e -> true))
                .isEqualTo(List.of());
        assertThat(parkingManagement.getParkingSpaces().get(PASSENGER_CAR_PLACES).findBy(e -> true))
                .isEqualTo(List.of(car));
    }

    @Test
    public void whenTwoTrucksGoToPassengerCarPlace() {
        Auto truckA = new Truck(2);
        Auto truckB = new Truck(2);
        ParkingManagement parkingManagement = new ParkingManagement(
                List.of(
                        new TruckParking(0),
                        new ParkingForPassengerCars(4)
                )
        );
        parkingManagement.manageParkingPlaces(truckA);
        parkingManagement.manageParkingPlaces(truckB);
        assertThat(parkingManagement.getParkingSpaces().get(TRUCK_PLACES).findBy(e -> true))
                .isEqualTo(List.of());
        assertThat(parkingManagement.getParkingSpaces().get(PASSENGER_CAR_PLACES).findBy(e -> true))
                .isEqualTo(List.of(truckA, truckB));
    }

    @Test
    public void whenTwoTrucksGoToTruckPlace() {
        Auto truckA = new Truck(10);
        Auto truckB = new Truck(5);
        ParkingManagement parkingManagement = new ParkingManagement(
                List.of(
                        new TruckParking(2),
                        new ParkingForPassengerCars(5)
                )
        );
        parkingManagement.manageParkingPlaces(truckA);
        parkingManagement.manageParkingPlaces(truckB);
        assertThat(parkingManagement.getParkingSpaces().get(TRUCK_PLACES).findBy(e -> true))
                .isEqualTo(List.of(truckA, truckB));
        assertThat(parkingManagement.getParkingSpaces().get(PASSENGER_CAR_PLACES).findBy(e -> true))
                .isEqualTo(List.of());
    }

    @Test
    public void whenTwoTrucksGoToTruckPlaceAndOnePassengerCarGoToPassengerCarPlace() {
        Auto car = new PassengerCar();
        Auto truck = new Truck(2);
        ParkingManagement parkingManagement = new ParkingManagement(
                List.of(
                        new TruckParking(1),
                        new ParkingForPassengerCars(2)
                )
        );
        parkingManagement.manageParkingPlaces(car);
        parkingManagement.manageParkingPlaces(truck);
        assertThat(parkingManagement.getParkingSpaces().get(TRUCK_PLACES).findBy(e -> true))
                .isEqualTo(List.of(truck));
        assertThat(parkingManagement.getParkingSpaces().get(PASSENGER_CAR_PLACES).findBy(e -> true))
                .isEqualTo(List.of(car));
    }

    @Test
    public void whenIncorrectTruckSizeValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Auto truck = new Truck(1);
        });
    }
}
