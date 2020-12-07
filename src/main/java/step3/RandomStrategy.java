package step3;

import java.util.Random;

public class RandomStrategy implements MoveStrategy {

    private final Random random = new Random();
    private int randomInt;

    private RandomStrategy(int randomInt) {
        validateRandomValue(randomInt);
        this.randomInt = randomInt;
    }

    private void validateRandomValue(int randomInt) {
        if(randomInt < 0 || randomInt > 9) {
            throw new IllegalArgumentException("랜덤값은 0보다 작거나 9보다 클 수 없습니다.");
        }
    }

    public static RandomStrategy valueOf(int randomInt) {
        return new RandomStrategy(randomInt);
    }

    public RandomStrategy() {
        this(new Random().nextInt(10));
    }

    @Override
    public boolean isMove() {
        return randomInt >= 4;
    }

    public int getRandomInt() {
        return randomInt;
    }
}
