package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("car 일급 콜렉션 객체 cars 생성")
    @Test
    void create() {
//        Cars cars = new Cars(new Car(0), new Car(0), new Car(0));
//        assertThat(cars).isEqualTo(new Cars(new Car(0), new Car(0), new Car(0)))
        // 이렇게 객체를 일일이 생성할 필요 ? -> X
        // cars 객체 내에서 생성해서 넣어줘도 될듯? 굳이 바깥에서 car 객체를 알 필요는 없는듯..
        // Cars 객체가 car 객체의 일급 컬렉션이라는 것만 알면 Car 객체를 바깥에서 알 필요 없음.
    }
}