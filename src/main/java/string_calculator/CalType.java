package string_calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalType {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b);

    private final String operator;
    private final BiFunction<Double, Double, Double> biFunction;

    CalType(String operator, BiFunction<Double, Double, Double> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public static int calculate(String operator, double num1, double num2) {
        return findOperator(operator).biFunction.apply(num1, num2).intValue();
    }

    private static CalType findOperator(String operator) {
        return Arrays.stream(values())
                     .filter(it -> it.operator.equals(operator))
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException("해당 연산자는 없는 연산자 입니다."));
    }
}
