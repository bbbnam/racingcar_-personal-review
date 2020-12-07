package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomStrategyTest {

    @DisplayName("랜덤값이 0~9 사이 값이 아닐 때 예외처리 메소드")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10, 100})
    void getRandomValueTest(int value) {
        assertThrows(IllegalArgumentException.class, () -> RandomStrategy.valueOf(value));
    }

    @DisplayName("랜덤값이 4이상일 경우 true인지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void getTrueConditionTest(int value) {
        RandomStrategy randomStrategy = RandomStrategy.valueOf(value);
        assertThat(randomStrategy.isMove()).isTrue();
    }

    @DisplayName("랜덤값이 4보다 작을 경우 false인지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void getFalseConditionTest(int value) {
        RandomStrategy randomStrategy = RandomStrategy.valueOf(value);
        assertThat(randomStrategy.isMove()).isFalse();
    }
}