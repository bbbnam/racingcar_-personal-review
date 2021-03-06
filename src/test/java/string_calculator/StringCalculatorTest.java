package string_calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringCalculatorTest {

    @DisplayName("덧셈")
    @Test
    void testAdd() {
        //given
        String input = "2 + 3 + 5";
        Expression expression = new StringExpression(input);
        StringCalculator stringCalculator = StringCalculator.of(expression);

        //when
        double result = stringCalculator.calculate();

        //then
        Assertions.assertThat(result).isEqualTo(10);
    }

    @DisplayName("뺄셈")
    @Test
    void testSubtract() {
        //given
        String input = "3 - 1 - 1";
        Expression expression = new StringExpression(input);
        StringCalculator stringCalculator = StringCalculator.of(expression);

        //when
        double result = stringCalculator.calculate();

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @DisplayName("곱셈")
    @Test
    void testMultyply() {
        //given
        String input = "2 * 3 * 7";
        Expression expression = new StringExpression(input);
        StringCalculator stringCalculator = StringCalculator.of(expression);

        //when
        double result = stringCalculator.calculate();

        //then
        Assertions.assertThat(result).isEqualTo(42);
    }

    @DisplayName("나눗셈")
    @Test
    void testDivide() {
        //given
        String input = "4 / 2 / 2";
        Expression expression = new StringExpression(input);
        StringCalculator stringCalculator = StringCalculator.of(expression);

        //when
        double result = stringCalculator.calculate();

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @DisplayName("입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void testNullorEmpty(String empty) {
        //given
        String input = empty;

        //when / then
        Assertions.assertThatThrownBy(()->
                new StringExpression(input))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException 발생")
    @Test
    void testExpression() {
        //given
        String input = "4 * 2 / 2 % 2";
        Expression expression = new StringExpression(input);

        //when / then
        StringCalculator stringCalculator = StringCalculator.of(expression);
        Assertions.assertThatThrownBy(()-> stringCalculator.calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산을 모두 포함하는 기능 구현")
    @Test
    void testAllExpression() {
        String input = "4 * 2 + 2 - 5 / 5";
        Expression expression = new StringExpression(input);
        StringCalculator stringCalculator = StringCalculator.of(expression);

        //when
        double result = stringCalculator.calculate();

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }
}
