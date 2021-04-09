package string_calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @DisplayName("덧셈")
    @Test
    void addTest() {
        //given
        String input = "2 + 3";

        //when
        StringCalculator stringCalculator = StringCalculator.of(input);
        int result = stringCalculator.calculate();

        //then
        Assertions.assertThat(result).isEqualTo(5);
    }

    @DisplayName("뺄셈")
    @Test
    void subtractTest() {
        //given
        String input = "3 - 1";

        //when
        StringCalculator stringCalculator = StringCalculator.of(input);
        int result = stringCalculator.calculate();

        //then
        Assertions.assertThat(result).isEqualTo(2);
    }

    @DisplayName("곱셈")
    @Test
    void multyplyTest() {
        //given
        String input = "2 * 3";

        //when
        StringCalculator stringCalculator = StringCalculator.of(input);
        int result = stringCalculator.calculate();

        //then
        Assertions.assertThat(result).isEqualTo(6);
    }

    @DisplayName("나눗셈")
    @Test
    void divideTest() {
        //given
        String input = "4 / 2";

        //when
        StringCalculator stringCalculator = StringCalculator.of(input);
        int result = stringCalculator.calculate();

        //then
        Assertions.assertThat(result).isEqualTo(2);
    }
}
