package retry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public Cars movedCars(MoveStrategy moveStrategy) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(decideMove(moveStrategy, car));
        }
        return new Cars(movedCars);
    }

    private Car decideMove(MoveStrategy moveStrategy, Car car) {
        if (moveStrategy.isMoveCondition()) {
            return car.move();
        }
        return car;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
