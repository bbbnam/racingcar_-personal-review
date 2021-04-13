package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameConsoleTest {

    @Test
    void start() {
        //when
        GameConsole gameConsole = new GameConsole(3, 5);

        //then
        assertThat(gameConsole.getCarsCount()).isEqualTo(3);
        assertThat(gameConsole.getTryCount()).isEqualTo(5);
    }
}
