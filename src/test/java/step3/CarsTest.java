package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CarsTest {

    @DisplayName("조건이 무조건 전진하게끔 되어 있을때, 차량 이동 테스트")
    @Test
    void moveAll() {
        Cars cars = Cars.of(3);

        Cars movedCars = cars.moveAll(new TestStratgy(true));

        Assertions.assertThat(movedCars.getCarPostions()).isEqualTo(
                Arrays.asList(new Position(1),new Position(1),new Position(1))
        );
    }
}
