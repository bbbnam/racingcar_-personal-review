package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Cars;
import step5.service.GameConsole;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameConsoleTest {

    @DisplayName("게임콘솔 생성 테스트")
    @Test
    void init() {
        //when
        GameConsole gameConsole = GameConsole.of("pobi,crong,honux", 5);

        //then
        assertThat(gameConsole.getCarsCount()).isEqualTo(3);
        assertThat(gameConsole.getTryCount()).isEqualTo(5);
    }

    @DisplayName("전진 조건에 따라 전진한 결과 테스트 - 무조건 전진하게끔 하는 전략 주입")
    @Test
    void move1() {
        //when
        GameConsole gameConsole = GameConsole.of("pobi,crong,honux", 5);
        List<Cars> result = gameConsole.start(new TestStratgy(true));


        //then
        List<Integer> expectedPositions = Arrays.asList(5, 5, 5);
        Cars lastPostions = result.get(result.size() - 1);
        assertThat(lastPostions.getCarPostions()).isEqualTo(expectedPositions);
    }

    @DisplayName("전진 조건에 따라 전진한 결과 테스트 - 전진 못하게 하는 전략 주입")
    @Test
    void move2() {
        //given
        GameConsole gameConsole = GameConsole.of("pobi,crong,honux", 5);

        //when
        List<Cars> result = gameConsole.start(new TestStratgy(false));

        //then
        List<Integer> expectedPositions = Arrays.asList(0, 0, 0);
        Cars lastPostions = result.get(result.size() - 1);
        assertThat(lastPostions.getCarPostions()).isEqualTo(expectedPositions);
    }
}
