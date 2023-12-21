package org.example;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        CarRegistry carRegistry = new CarRegistry();
        ImmutableCar carA = new ImmutableCar("Orest", LocalDateTime.now());
        ImmutableCar carB = new ImmutableCar("Bogdan", LocalDateTime.now());
        ImmutableCar carC = new ImmutableCar("Nazar", LocalDateTime.now());
        ImmutableCar carANewOwner = new ImmutableCar(carA.getId(), "Dmytro", LocalDateTime.now());
        carRegistry.addCar(carA);
        carRegistry.addCar(carB);
        carRegistry.addCar(carC);
        System.out.println(carRegistry.getHistoryForCar(carA.getId()));
        System.out.println(carRegistry.getHistoryForCar(carB.getId()));
        System.out.println(carRegistry.getHistoryForCar(carC.getId()));
        carRegistry.addCar(carANewOwner);
        System.out.println(carRegistry.getHistoryForCar(carA.getId()));
        System.out.println(carRegistry.getCurrentOwners());
    }
}
