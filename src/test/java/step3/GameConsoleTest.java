package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameConsoleTest {

    @DisplayName("게임콘솔 생성 테스트")
    @Test
    void init() {
        //when
        GameConsole gameConsole = new GameConsole(3, 5);

        //then
        assertThat(gameConsole.getCarsCount()).isEqualTo(3);
        assertThat(gameConsole.getTryCount()).isEqualTo(5);
    }

    @DisplayName("전진 조건에 따라 전진한 결과 테스트 - 무조건 전진하게끔 하는 전략 주입")
    @Test
    void move1() {
        //when
        GameConsole gameConsole = new GameConsole(3, 5);
        gameConsole.start(new TestStratgy(true));
        GameResult result = gameConsole.getResult();

        //then
        List<Position> expectedPositions = Arrays.asList(new Position(5), new Position(5), new Position(5));
        assertThat(result.getCarPositions()).isEqualTo(expectedPositions);
    }

    @DisplayName("전진 조건에 따라 전진한 결과 테스트 - 전진 못하게 하는 전략 주입")
    @Test
    void move2() {
        //given
        GameConsole gameConsole = new GameConsole(3, 5);

        //when
        gameConsole.start(new TestStratgy(false));

        //then
        GameResult result = gameConsole.getResult();
        List<Position> expectedPositions = Arrays.asList(new Position(0), new Position(0), new Position(0));
        assertThat(result.getCarPositions()).isEqualTo(expectedPositions);
    }
}
