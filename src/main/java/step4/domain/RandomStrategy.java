package step4.domain;

import java.util.Random;

public class RandomStrategy implements MoveStrategy {

    @Override
    public boolean isMove() {
        return new Random().nextInt(10) >= 4;
    }
}
