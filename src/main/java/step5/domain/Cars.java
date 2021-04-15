package step5.domain;

import step5.exception.IllegalCarsException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCars(cars);
        this.cars = cars;
    }

    private void validateCars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalCarsException();
        }
    }

    public static Cars of(List<CarName> carNames) {
        List<Car> newCars = new ArrayList<>();
        for (CarName carName : carNames) {
            newCars.add(Car.of(carName.getName(), 0));
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
                .map(Car::getPostion)
                .collect(Collectors.toList());
    }

    public int getCount() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    public String drawAll() {
        return cars.stream()
                   .map(car -> car.getCarName() +" : "+car.drawPostion())
                   .collect(Collectors.joining("\n"));

    }
}
