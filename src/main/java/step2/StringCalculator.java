package step2;

import java.util.Objects;

public class StringCalculator {

    private String [] separate(String expression) {
        checkEmpty(expression);
        return expression.split(" ");
    }

    private void checkEmpty(String expression) {
        if (Objects.isNull(expression) || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값은 null 또는 빈값이 올 수 없습니다.");
        }
    }

    public int calculate(String expression) {
        String [] expressions = separate(expression);
        int sum = Integer.parseInt(expressions[0]);
        for (int i = 1; i < expressions.length; i+=2) {
            sum = Operator.find(expressions[i]).calculate(sum, expressions[i + 1]);
        }
        return  sum;
    }
}
