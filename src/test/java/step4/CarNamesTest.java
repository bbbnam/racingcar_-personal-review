package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step4.domain.CarName;
import step4.domain.CarNames;
import step4.exception.IllegalInputException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNamesTest {

    @DisplayName("차 이름에 대한 유효성 검사")
    @Test
    void createCarNames() {
        CarNames carNames = CarNames.of("pobi,crong,honux");

        assertThat(carNames.getCarNames()).isEqualTo(Arrays.asList(
                CarName.of("pobi"), CarName.of("crong"), CarName.of("honux")
        ));
    }

    @DisplayName("차 이름 유효성 검사 - 빈값 검사")
    @ParameterizedTest
    @NullAndEmptySource
    void validateCarNames(String emptyCarNames) {
        assertThatThrownBy(() ->
            CarNames.of(emptyCarNames)
        ).isInstanceOf(IllegalInputException.class)
        .hasMessage("공백이나 빈 값은 입력할 수 없습니다.");
    }
}
