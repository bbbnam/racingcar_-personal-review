package step3.domain;

import step3.exception.IllegalContestsException;

public class Contests {

    private final int tryNumbers;

    private Contests(int tryNumbers) {
        validateContests(tryNumbers);
        this.tryNumbers = tryNumbers;
    }

    private void validateContests(int tryNumbers) {
        if (tryNumbers <= 0) {
            throw new IllegalContestsException();
        }
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
