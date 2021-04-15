package string_calculator;

import java.util.regex.Pattern;

public class StringExpression implements Expression {
    private static final String DELIMITER = " ";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(^[0-9]*$)");

    private final String[] expressions;

    public StringExpression(String input) {
        validateInputString(input);
        this.expressions = split(input);
    }

    private static void validateInputString(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 계산할 수 없습니다.");
        }
    }

    private static String[] split(String input) {
        return input.split(DELIMITER);
    }

    @Override
    public String[] checkExpression() {
        if (expressions.length % 2 == 0) {
            throw new IllegalArgumentException("수식은 사칙연산 혹은 연속된 숫자로 끝날 수 없습니다.");
        }

        for (int index = 0 ; index < expressions.length; index++) {
            checkDetail(index, expressions[index]);
        }
        return expressions;
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
