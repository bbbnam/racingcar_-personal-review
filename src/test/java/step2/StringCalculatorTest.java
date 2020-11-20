package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @DisplayName("덧셈 테스트")
    @Test
    void additionTest() {
        StringCalculator stringCalulator = new StringCalculator("3 + 5");
        int result = stringCalulator.calculate();
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void subtractTest() {
        StringCalculator stringCalulator = new StringCalculator("6 - 2");
        int result = stringCalulator.calculate();
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiplyTest() {
        StringCalculator stringCalulator = new StringCalculator("10 * 3");
        int result = stringCalulator.calculate();
        assertThat(result).isEqualTo(30);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void divisionTest() {
        StringCalculator stringCalulator = new StringCalculator("15 / 3");
        int result = stringCalulator.calculate();
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("입력값이 null 또는 빈 공백 문자일 경우 - IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    void validNullorEmptyString(String nullorEmpty) {
        StringCalculator stringCalulator = new StringCalculator(nullorEmpty);
        assertThatThrownBy(() -> {
            stringCalulator.calculate();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 사칙연산 기호가 아닌 경우 - IllegalArgumentException")
    @Test
    void validOperations() {
        StringCalculator stringCalulator = new StringCalculator("3 & 6");
        assertThatThrownBy(() -> {
            stringCalulator.calculate();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
