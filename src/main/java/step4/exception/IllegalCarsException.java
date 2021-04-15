package step4.exception;

public class IllegalCarsException extends RuntimeException {

    private static final String CARS_EXCEPTION_MESSAGE = "차량 대수는 최소 1대 이상이어야 합니다.";

    public IllegalCarsException() {
        super(CARS_EXCEPTION_MESSAGE);
    }
}
