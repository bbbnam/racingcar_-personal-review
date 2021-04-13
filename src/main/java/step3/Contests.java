package step3;

public class Contests {

    private final int tryNumbers;

    private Contests(int tryNumbers) {
        this.tryNumbers = tryNumbers;
    }

    public static Contests of(int tryNumbers) {
        return new Contests(tryNumbers);
    }

    public int getCount() {
        return tryNumbers;
    }

    public void start(Cars cars, MoveCondition moveStratgy) {
        for (int i = 0; i < tryNumbers; i++) {
            cars.moveAll(moveStratgy);
        }
    }
}
