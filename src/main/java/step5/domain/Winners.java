package step5.domain;

import java.util.List;

public class Winners {

    private final Cars records;

    public Winners(Cars records) {
        this.records = records;
    }

    public List<Car> findWinner() {
        Car maxPositionCar = records.findMaxPosition();
        return records.findSamePosition(maxPositionCar);
    }
}
