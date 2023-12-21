package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CarRegistry {
    private final List<ImmutableCar> cars;

    private final Map<UUID, List<ImmutableCar>> carsHistory;

    public CarRegistry() {
        cars = new ArrayList<>();
        carsHistory = new HashMap<>();
    }

    public void addCar(ImmutableCar car) {
        if (carsHistory.containsKey(car.getId())) {
            List<ImmutableCar> carHistory = carsHistory.get(car.getId());
            carHistory.add(car);
            int i = carHistory.indexOf(car);
            if (i > 0) {
                cars.remove(carHistory.get(i - 1));
            }
        } else {
            LinkedList<ImmutableCar> carHistory = new LinkedList<>();
            carHistory.add(car);
            carsHistory.put(car.getId(), carHistory);
        }
        cars.add(car);
    }

    public List<ImmutableCar> getHistoryForCar(UUID carId) {
        return new LinkedList<>(carsHistory.get(carId));
    }

    public List<ImmutableCar> getCurrentOwners() {
        return new LinkedList<>(cars);
    }

}
