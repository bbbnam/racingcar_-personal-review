package step3.domain;

import step3.exception.IllegalInputException;

import java.util.regex.Pattern;

public class InputNumber {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(^[0-9]*$)");

    private final int input;

    private InputNumber(String input) {
        validateInput(input);
        this.input = convertToInt(input);
    }

    private void validateInput(String input) {
        checkNullorEmpty(input);
        checkNumber(input);
    }

    private void checkNullorEmpty(String input) {
        if (isNullorEmpty(input)) {
            throw new IllegalInputException();
        }
    }

    private void checkNumber(String input) {
        if (isNumber(input)) {
            throw new NumberFormatException();
        }
    }

    private boolean isNumber(String input) {
        return NUMBER_PATTERN.matcher(input).find();
    }

    private boolean isNullorEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    public static InputNumber of(String input) {
        return new InputNumber(input);
    }

    public int getInt() {
        return input;
    }
}
