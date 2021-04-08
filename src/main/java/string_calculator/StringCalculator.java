package string_calculator;

public class StringCalculator {

    private final String[] splitedInput;

    private StringCalculator(String[] input) {
        this.splitedInput = input;
    }

    public static StringCalculator of(String input) {
        validateInputString(input);
        return new StringCalculator(split(input));
    }

    private static void validateInputString(String input) {

    }

    private static String[] split(String input) {
        return input.split(" ");
    }

    public int calculate() {
        return CalType.calculate(splitedInput[1], Double.parseDouble(splitedInput[0]), Double.parseDouble(splitedInput[2]));
    }
}
