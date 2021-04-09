package string_calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(^[0-9]*$)");
    private static final String DELIMITER = " ";
    private final String[] splitedInput;

    private StringCalculator(String[] input) {
        this.splitedInput = input;
    }

    public static StringCalculator of(String input) {
        validateInputString(input);
        return new StringCalculator(split(input));
    }

    private static void validateInputString(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 계산할 수 없습니다.");
        }
    }

    private static String[] split(String input) {
        return input.split(DELIMITER);
    }

    public double calculate() {
        checkExpression(splitedInput);
        double calculated = convertNumber(splitedInput[0]);
        for (int i = 1; i < splitedInput.length; i +=2) {
            calculated = CalType.calculate(splitedInput[i], calculated, convertNumber(splitedInput[i+1]));
        }
        return calculated;
    }

    private void checkExpression(String[] splitedInput) {
        if (splitedInput.length % 2 == 0) {
            throw new IllegalArgumentException("수식은 사칙연산 혹은 연속된 숫자로 끝날 수 없습니다.");
        }

        for (int index = 0 ; index < splitedInput.length; index++) {
            checkDetail(index, splitedInput[index]);
        }
    }

    private double convertNumber(String input) {
        return Double.parseDouble(input);
    }

    private void checkDetail(int index, String oneInput) {
        if (index % 2 == 0 && !isNumber(oneInput)) {
            throw new IllegalArgumentException("올바른 수식이 아닙니다.1");
        }
        if (index % 2 == 1 && isNumber(oneInput)) {
            throw new IllegalArgumentException("올바른 수식이 아닙니다.2");
        }
    }

    private boolean isNumber(String oneInput) {
        return NUMBER_PATTERN.matcher(oneInput).find();
    }
}
