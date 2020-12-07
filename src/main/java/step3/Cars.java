package step3;

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

    public Cars move() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(new RandomStrategy());
        }
        return new Cars(cars);
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

    public void print() {

    }
}
