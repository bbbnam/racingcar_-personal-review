package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import step3.domain.NumberGenerator;
import step3.domain.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    @DisplayName("생성된 랜덤값이 0과 9사이에 있는 숫자인지 테스트")
    @RepeatedTest(100)
    void generate1() {
        //given
        NumberGenerator generator = new RandomGenerator();

        //when / then
        assertThat(generator.generate()).isBetween(0, 9);
    }
}
