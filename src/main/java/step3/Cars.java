package step3;

import java.util.ArrayList;
import java.util.List;

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
}
