package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars ValueOf(int numberOfCar) {
        return addCars(numberOfCar);
    }

    private static Cars addCars(int numberOfCar) {
        List<Car> addedCars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            addedCars.add(new Car(0));
        }
        return new Cars(addedCars);
    }

    public int getCarCount() {
        return cars.size();
    }

    public Cars moveAll(MoveStrategy moveStrategy) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car: cars) {
            movedCars.add(car.move(moveStrategy));
        }
        return new Cars(movedCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            sb.append(cars.get(i).print());
        }
        return sb.toString();
    }
}
