package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("경주에 참여하는 차에 관련한 테스트")
class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new Position(0));
    }

    @Test
    @DisplayName("차량 이동 테스트 - 외부에서 조건 주입")
    void move() {
        car.move(() -> true);

        assertThat(car).isEqualTo(new Car(new Position(1)));
    }
}
