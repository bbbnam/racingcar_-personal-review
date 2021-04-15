package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Car;
import step5.domain.Cars;
import step5.domain.Winners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @DisplayName("승리자 찾는 테스트")
    @Test
    void findWinners() {
        List<Cars> finalRecord = new ArrayList<>();
        Car pobi = Car.of("pobi", 4);
        Car crong = Car.of("crong", 4);
        Car honux = Car.of("honux", 1);
        finalRecord.add(new Cars(Arrays.asList(pobi,crong,honux)));

        Winners winners = Winners.of(finalRecord);

        assertThat(winners.getWinners()).containsExactly(pobi, crong);
    }
}