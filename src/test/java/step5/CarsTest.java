package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.CarName;
import step5.domain.Cars;
import step5.exception.IllegalCarsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @DisplayName("조건이 무조건 전진하게끔 되어 있을때, 차량 이동 테스트")
    @Test
    void moveAll() {
        Cars cars = Cars.of(Arrays.asList(CarName.of("pobi"), CarName.of("crong"), CarName.of("honux")));

        Cars movedCars = cars.moveAll(new TestStratgy(true));
        List<Integer> carPostions = movedCars.getCarPostions();

        assertThat(carPostions).isEqualTo(
                Arrays.asList(1, 1, 1)
        );
    }

    @DisplayName("차량 유효성 검사 - 차량 대수가 1개 미만시 예외발생")
    @Test
    void validateCars() {
       assertThatThrownBy(() ->
               Cars.of(new ArrayList<>())
       ).isInstanceOf(IllegalCarsException.class)
       .hasMessage("차량 대수는 최소 1대 이상이어야 합니다.");
    }
}
