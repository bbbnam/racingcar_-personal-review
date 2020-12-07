package step3;

import step3.domain.Cars;
import step3.domain.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {

    private final int racingCount;
    private final int carsCount;

    public RacingGame(int racingCount, int carsCount) {
        this.racingCount = racingCount;
        this.carsCount = carsCount;
    }

    public int getRacingCount() {
        return racingCount;
    }

    public Result progress(MoveStrategy moveStrategy) {
        List<Cars> result = new ArrayList<>();
        Cars moved = Cars.ValueOf(carsCount);
        for (int i = 0; i < racingCount; i++) {
            moved = moved.moveAll(moveStrategy);
            result.add(moved);
        }
        return new Result(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return racingCount == that.racingCount &&
                carsCount == that.carsCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCount, carsCount);
    }
}
