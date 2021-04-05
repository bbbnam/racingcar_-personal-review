import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("1,2 를 split 했을때 테스트")
    @Test
    void splitTest() {
        String str = "1,2";

        String[] splited = str.split(",");

        assertThat(splited).containsExactly("1", "2");
    }

    @DisplayName("1 를 split 했을때 테스트")
    @Test
    void splitTest2() {
        String str = "1";

        String[] splited = str.split(",");

        assertThat(splited).containsExactly("1");
    }

    @DisplayName("(1,2) 값이 주어졌을 때 substring() 활용 테스트")
    @Test
    void substringTest() {
        String str = "(1,2)";

        String substring = str.substring(1, 4);

        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("abc 값이 주어졌을 때 특정 위치 문자 가져오기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"abc:0:a", "abc:1:b", "abc:2:c"}, delimiter = ':')
    void charAtTest(String str, int index, char expected) {
        char charAt = str.charAt(index);

        assertThat(charAt).isEqualTo(expected);
    }

    @DisplayName("특정 위치 문자 가져올 때, 위치 값 벗어나면 예외 테스트")
    @Test
    void charAtTestException() {
        String str = "abc";

        assertThatThrownBy(()-> {
            str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessage("String index out of range: 3");
    }
}
