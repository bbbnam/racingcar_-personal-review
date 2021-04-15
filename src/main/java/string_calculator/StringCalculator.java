package string_calculator;

public class StringCalculator {

    private final Expression expression;

    private StringCalculator(Expression expression) {
        this.expression = expression;
    }

    public static StringCalculator of(Expression expression) {
        return new StringCalculator(expression);
    }

    public double calculate() {
        String[] expressions = expression.checkExpression();
        double calculated = convertNumber(expressions[0]);
        for (int i = 1; i < expressions.length; i +=2) {
            calculated = CalType.calculate(expressions[i], calculated, convertNumber(expressions[i+1]));
        }
        return calculated;
    }

    private double convertNumber(String input) {
        return Double.parseDouble(input);
    }
}
