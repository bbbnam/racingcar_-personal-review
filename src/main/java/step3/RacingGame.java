package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {

    private final int racingCount;
    private final Cars cars;

    public RacingGame(int racingCount, Cars cars) {
        this.racingCount = racingCount;
        this.cars = cars;
    }

    public int getRacingCount() {
        return racingCount;
    }

    public Result progress() {
        List<Cars> result = new ArrayList<>();
        for (int i = 0; i < racingCount; i++) {
            result.add(cars.move());
        }
        return new Result(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return racingCount == that.racingCount &&
                Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCount, cars);
    }
}
