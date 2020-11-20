package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator stringCalulator = new StringCalculator();

    @DisplayName("덧셈 테스트")
    @Test
    void additionTest() {
        int result = stringCalulator.calculate("3 + 5");
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void subtractTest() {
        int result = stringCalulator.calculate("6 - 2");
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiplyTest() {
        int result = stringCalulator.calculate("10 * 3");
        assertThat(result).isEqualTo(30);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void divisionTest() {
        int result = stringCalulator.calculate("15 / 3");
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("입력값이 null 또는 빈 공백 문자일 경우 - IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    void validNullorEmptyString(String nullorEmpty) {
        assertThatThrownBy(() -> {
            stringCalulator.calculate(nullorEmpty);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("입력값은 null 또는 빈값이 올 수 없습니다.");
    }

    @DisplayName("입력값이 사칙연산 기호가 아닌 경우 - IllegalArgumentException")
    @Test
    void validOperations() {
        assertThatThrownBy(() -> {
            stringCalulator.calculate("3 & 6");
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("사칙연산 기호가 아닙니다.");
    }
}
