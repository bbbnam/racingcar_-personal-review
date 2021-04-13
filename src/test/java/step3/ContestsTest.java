package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ContestsTest {

    @DisplayName("대회 진행 테스트")
    @Test
    void start() {
        Cars cars = Cars.of(3);
        Contests contests = Contests.of(2);

        contests.start(cars, new TestStratgy(true));
        assertThat(cars.getCarPostions()).isEqualTo(Arrays.asList(new Position(2), new Position(2), new Position(2)));
    }
}
