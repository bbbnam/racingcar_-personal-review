package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Contests;
import step3.exception.IllegalContestsException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ContestsTest {

    @DisplayName("대회 진행 유효성 검사 - 시도 횟수가 1회 미만이면 예외발생")
    @Test
    void validateContests() {
        assertThatThrownBy(() ->
                Contests.of(0)
        ).isInstanceOf(IllegalContestsException.class)
         .hasMessage("시도 횟수는 0보다 커야 합니다.");
    }
}
