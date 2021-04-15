package step4.exception;

public class IllegalCarNameException extends RuntimeException{

    private static final String NAME_EXCEPTION_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";

    public IllegalCarNameException() {
        super(NAME_EXCEPTION_MESSAGE);
    }
}
