package step4.domain;

import step4.exception.IllegalContestsException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class Contests {

    private Stream<Integer> tryNumbers;

    private Contests(int tryNumbers) {
        validateContests(tryNumbers);
        this.tryNumbers = Arrays.stream(new int[tryNumbers]).boxed();
    }

    private void validateContests(int tryNumbers) {
        if (tryNumbers <= 0) {
            throw new IllegalContestsException();
        }
    }

    public static Contests of(int tryNumbers) {
        return new Contests(tryNumbers);
    }

    public Iterator<Integer> progressContest() {
        return tryNumbers.iterator();
    }

    public int getTryCount() {
        return Long.valueOf(tryNumbers.count()).intValue();
    }
}
