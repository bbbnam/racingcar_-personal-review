package step5.exception;

public class IllegalInputException extends RuntimeException {

    private static final String INPUT_EXCEPTION_MESSAGE = "공백이나 빈 값은 입력할 수 없습니다.";

    public IllegalInputException() {
        super(INPUT_EXCEPTION_MESSAGE);
    }
}
