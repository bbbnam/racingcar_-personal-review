package step3;

import step3.domain.Cars;
import step3.domain.Position;

import java.util.List;

public class GameResult {

    private final Cars cars;

    public GameResult(Cars cars) {
        this.cars = cars;
    }

    public List<Position> getCarPositions() {
        return cars.getCarPostions();
    }
}
