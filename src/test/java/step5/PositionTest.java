package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.domain.Position;
import step5.exception.IllegalPositionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("포지션 값 증가 테스트")
    @Test
    void increase() {
        Position position = Position.of(0);

        position.increase();

        assertThat(position.getNowPosition()).isEqualTo(1);
    }

    @DisplayName("포지션 값 유효성 체크 - 음수 불가")
    @ParameterizedTest
    @ValueSource(ints = {-1, -10})
    void validatePostion(int inputPosition) {
        assertThatThrownBy(() ->
                Position.of(inputPosition)
        ).isInstanceOf(IllegalPositionException.class)
        .hasMessage("잘못된 위치값 입니다.");
    }
}