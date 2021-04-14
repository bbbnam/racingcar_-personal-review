package step3.exception;

public class IllegalContestsException extends RuntimeException {

    private final static String CONTEST_EXCEPTION_MESSAGE = "시도 횟수는 0보다 커야 합니다.";

    public IllegalContestsException() {
        super(CONTEST_EXCEPTION_MESSAGE);
    }
}
