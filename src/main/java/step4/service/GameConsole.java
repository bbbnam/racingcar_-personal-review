package step4.service;

import step4.domain.Cars;
import step4.domain.Contests;
import step4.domain.MoveCondition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameConsole {

    private final Cars cars;
    private final Contests contests;

    private GameConsole(Cars cars, Contests contests) {
        this.cars = cars;
        this.contests = contests;
    }

    public static GameConsole of(int carsCount, int tryNumbers) {
        return new GameConsole(Cars.of(carsCount), Contests.of(tryNumbers));
    }

    public List<Cars> start(MoveCondition moveStratgy) {
        List<Cars> results = new ArrayList<>();
        Iterator<Integer> intendedRace = contests.progressContest();
        while (intendedRace.hasNext()) {
            results.add(cars.moveAll(moveStratgy));
            intendedRace.next();
        }
        return results;
    }

    public int getCarsCount() {
        return cars.getCount();
    }

    public int getTryCount() {
        return contests.getTryCount();
    }
}
