package step3;

public class GameConsole {

    private final Cars cars;
    private final Contests contests;

    public GameConsole(int carsCount, int tryNumbers) {
        this.cars = Cars.of(carsCount);
        this.contests = Contests.of(tryNumbers);
    }

    public int getCarsCount() {
        return cars.getCount();
    }

    public int getTryCount() {
        return contests.getCount();
    }
}
