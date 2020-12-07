package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("car 일급 콜렉션 객체 cars 생성")
    @Test
    void create() {
        Cars cars = Cars.ValueOf(3);
        assertThat(cars.getCarCount()).isEqualTo(3);
    }
}