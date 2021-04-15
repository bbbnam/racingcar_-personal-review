package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.MoveStratgy;

import static org.assertj.core.api.Assertions.assertThat;

class MoveStratgyTest {

    @DisplayName("랜덤값이 0~9 값 중 4 이상일 경우 전진 조건 true 나오게 하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8})
    void isMovable_true(int number) {
        MoveStratgy randomStratgy = new MoveStratgy(() -> number);

        assertThat(randomStratgy.isMovable()).isTrue();
    }

    @DisplayName("랜덤값이 0~9 값 중  4 미만일 경우 전진 조건 false 나오게 하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void isMovable_false(int number) {
        MoveStratgy randomStratgy = new MoveStratgy(() -> number);

        assertThat(randomStratgy.isMovable()).isFalse();
    }
}
