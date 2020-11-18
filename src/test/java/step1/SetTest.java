package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set 사이즈 체크")
    @Test
    void checkSetSize() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("1,2,3 값 존재여부 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int expected) {
        assertThat(numbers.contains(expected)).isTrue();
    }

    @DisplayName("contains 결과값 참이 아닌 경우도 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true",  "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
