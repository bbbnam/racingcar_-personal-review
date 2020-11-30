package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("자동차 객체 생성 테스트")
    @Test
    void create() {
        Car car = new Car(3);
        assertThat(car).isEqualTo(new Car(3));
    }

    @DisplayName("외부에서 포지션 증가 테스트")
    @Test
    void validatePositionUp() {
        Car car = new Car(3);
        car.addPosition();
        assertThat(car.getPosition()).isEqualTo(4);
    }
}