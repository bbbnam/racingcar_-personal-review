package step4.domain;

import step4.exception.IllegalCarsException;

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
        for (int i = 0; i < carNames.size(); i++) {
            newCars.add(Car.of(carNames.get(i).getName(), 0));
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

    public List<Car> getCars() {
        return cars;
    }

    public String drawAll() {
        return cars.stream()
                   .map(car -> car.getCarName() +" : "+car.drawPostion())
                   .collect(Collectors.joining("\n"));

    }
}
