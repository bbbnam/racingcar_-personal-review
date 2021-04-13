package step3;

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
