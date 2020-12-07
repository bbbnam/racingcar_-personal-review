package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("RacingGame 객체 생성 테스트")
    @Test
    void create() {
        RacingGame racingGame = new RacingGame(3, 3);
        assertThat(racingGame).isEqualTo(new RacingGame(3, 3));
    }

    @DisplayName("시도 횟수에 따라 결과값 진행 테스트")
    @Test
    void getResult() {
        RacingGame racingGame = new RacingGame(5, 3);
        Result result = racingGame.progress(new MoveTestStrategy(true));
        assertThat(result.getResultSize()).isEqualTo(5);
    }
}