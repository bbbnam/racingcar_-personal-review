package step3.domain;

import step3.exception.IllegalCarsException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalCarsException();
        }
    }

    public static Cars of(int carsCount) {
        List<Car> newCars = new ArrayList<>();
        for (int i = 0; i < carsCount; i++) {
            newCars.add(new Car(0));
        }
        return new Cars(newCars);
    }

    public Cars moveAll(MoveCondition moveStratgy) {
        List<Car> results = new ArrayList<>();
        for (Car car : cars) {
            results.add(car.move(moveStratgy));
        }
        return new Cars(results);
    }

    public List<Integer> getCarPostions() {
        return cars.stream()
                   .map(car -> car.getPostion())
                   .collect(Collectors.toList());
    }

    public int getCount() {
        return cars.size();
    }

    public String drawAll() {
        return cars.stream()
                   .map(car -> car.drawPostion())
                   .collect(Collectors.joining("\n"));

    }
}
