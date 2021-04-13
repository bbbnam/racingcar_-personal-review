package step3;

public class GameConsole {

    private final Cars cars;
    private final Contests contests;

    public GameConsole(int carsCount, int tryNumbers) {
        this.cars = Cars.of(carsCount);
        this.contests = Contests.of(tryNumbers);
    }

    public void start(MoveCondition moveStratgy) {
        contests.start(cars, moveStratgy);
    }

    public GameResult getResult() {
        return new GameResult(cars);
    }

    public int getCarsCount() {
        return cars.getCount();
    }

    public int getTryCount() {
        return contests.getCount();
    }
}
