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
}
