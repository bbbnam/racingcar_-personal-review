package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(int carsCount) {
        List<Car> newCars = new ArrayList<>();
        for (int i = 0; i < carsCount; i++) {
            newCars.add(new Car(0));
        }
        return new Cars(newCars);
    }

    public int getCount() {
        return cars.size();
    }
}
