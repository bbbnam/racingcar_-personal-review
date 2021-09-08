package retry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("Car 일급컬렉션 클래스 생성 테스트")
    @Test
    public void createCars() throws Exception {
        Cars cars = new Cars(Arrays.asList(new Car(0), new Car(1), new Car(2)));

        assertThat(cars.getCars()).containsExactly(new Car(0), new Car(1), new Car(2));
    }

    @Test
    void movedCars() {
        //given
        Cars cars = new Cars(Arrays.asList(new Car(0), new Car(1), new Car(2)));

        //when
        Cars movedCars = cars.movedCars(() -> true);

        //then
        assertThat(movedCars.getCars()).containsExactly(new Car(1), new Car(2), new Car(3));
    }
}