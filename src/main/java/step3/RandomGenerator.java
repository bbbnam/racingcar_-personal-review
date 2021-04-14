package step3;

import java.util.Random;

public class RandomGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
