package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Car;
import step4.exception.IllegalCarNameException;
import step4.exception.IllegalInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("경주에 참여하는 차에 관련한 테스트")
class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.of("pobi", 0);
    }

    @DisplayName("차량 이동 테스트 - 외부에서 조건 주입")
    @Test
    void move() {
        Car movedCar = car.move(() -> true);

        assertThat(movedCar).isEqualTo(Car.of("pobi", 1));
        assertThat(movedCar.getPostion()).isEqualTo(1);
    }

    @DisplayName("자동차 이름 부여")
    @Test
    void namedCar() {
        Car pobiCar = Car.of("pobi", 0);

        assertThat(pobiCar.getCarName()).isEqualTo("pobi");
    }

    @DisplayName("자동차 이름 부여 유효성 검사 - 자동차 이름은 5자를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"hellow", "crisis", "baboda"})
    void validateName1(String carName) {
        assertThatThrownBy(() ->
                Car.of(carName, 0)
        ).isInstanceOf(IllegalCarNameException.class)
        .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("자동차 이름 부여 유효성 검사 - 자동차 이름은 공백이나 빈값이 올 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateName2(String carName) {
        assertThatThrownBy(() ->
                Car.of(carName, 0)
        ).isInstanceOf(IllegalInputException.class)
        .hasMessage("공백이나 빈 값은 입력할 수 없습니다.");
    }
}
