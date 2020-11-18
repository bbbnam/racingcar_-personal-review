package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("1,2 분리")
    @Test
    void splitTest_1_1() {
        String input = "1,2";
        String [] splitStr = input.split(",");
        assertThat(splitStr).contains("1","2");
    }

    @DisplayName("1 분리")
    @Test
    void splitTest_1_2() {
        String input = "1";
        String [] splitStr = input.split(",");
        assertThat(splitStr).containsExactly("1");
    }

    @DisplayName("괄호제거")
    @Test
    void splitTest_2() {
        String input = "(1,2)";
        String result = input.substring(1,input.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 활용하여 특정 위치 값 가져오기")
    @Test
    void splitTest_3() {
        String input = "abc";
        char result = input.charAt(0);
        assertThat(result).isEqualTo('a');

        assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessage("String index out of range: 3");
    }
}
