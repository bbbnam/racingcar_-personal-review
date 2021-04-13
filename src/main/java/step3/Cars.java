package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
