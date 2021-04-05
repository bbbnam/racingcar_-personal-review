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

    @DisplayName("주어진 set의 길이 테스트")
    @Test
    void sizeTest() {
        //assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("set에 contains 메소드를 활용해서 1,2,3 값이 존재하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int expected) {
        //assertThat(numbers.contains(expected)).isTrue();
        assertThat(numbers).contains(expected);
    }

    @DisplayName("set에 contains 메소드를 활용해서 존재하는 1,2,3은 true , 4,5는 false 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains2(int given, boolean expected) {
        assertThat(numbers.contains(given)).isEqualTo(expected);
    }
}
