package retry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("차 객체 생성 테스트")
    @Test
    void createCarTest() {
        Car car = new Car(3);

        assertThat(car).isEqualTo(new Car(3));
    }

    @DisplayName("차 객체 이동 테스트")
    @Test
    void movedCar() {
        Car car = new Car(0);

        Car movedCar = car.move();

        assertThat(movedCar.getPosition()).isEqualTo(1);
    }
}