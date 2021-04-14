package step3;

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
        for (Car car : cars) {
            car.move(moveStratgy);
        }
        return this;
    }

    public List<Position> getCarPostions() {
        return cars.stream()
                   .map(car -> car.getPostion())
                   .collect(Collectors.toList());
    }

    public int getCount() {
        return cars.size();
    }
}
