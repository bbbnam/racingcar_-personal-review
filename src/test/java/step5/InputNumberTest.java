package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step5.domain.InputNumber;
import step5.exception.IllegalInputException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumberTest {

    @DisplayName("입력값 빈값 입력시 예외발생 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullorEmpty(String nullOrEmpty) {
        assertThatThrownBy(()->
                InputNumber.of(nullOrEmpty)
        ).isInstanceOf(IllegalInputException.class)
        .hasMessage("공백이나 빈 값은 입력할 수 없습니다.");
    }

    @DisplayName("입력값이 숫자가 아닌 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"$", "f", "A", "e", "-"})
    void validateNumber(String notNumber) {
        assertThatThrownBy(()->
            InputNumber.of(notNumber)
        ).isInstanceOf(NumberFormatException.class);
    }
}
