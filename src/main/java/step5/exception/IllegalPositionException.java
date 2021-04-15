package step5.exception;

public class IllegalPositionException extends RuntimeException{

    private final static String POSITION_EXCEPTION_MESSAGE = "잘못된 위치값 입니다.";

    public IllegalPositionException() {
        super(POSITION_EXCEPTION_MESSAGE);
    }
}
