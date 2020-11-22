package step2;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operator {
    ADDITION("+", (num1, num2) -> num1 + num2),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVISION("/", (num1, num2) -> num1 / num2);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public static Operator find(String operator) {
        checkOperatorEmpty(operator);
        return Stream.of(values())
              .filter(type -> type.operator.equals(operator))
              .findFirst()
              .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }

    private static void checkOperatorEmpty(String operator) {
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException("연산자에 빈값이 올 수 없습니다.");
        }
    }

    public int calculate(int sum, String nextNum) {
        int num = Integer.parseInt(nextNum);
        return this.biFunction.apply(sum, num);
    }
}
