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
}
