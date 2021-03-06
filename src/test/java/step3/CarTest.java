package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("경주에 참여하는 차에 관련한 테스트")
class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(0);
    }

    @DisplayName("차량 이동 테스트 - 외부에서 조건 주입")
    @Test
    void move() {
        Car movedCar = car.move(() -> true);

        assertThat(movedCar).isEqualTo(new Car(1));
        assertThat(movedCar.getPostion()).isEqualTo(1);
    }
}
