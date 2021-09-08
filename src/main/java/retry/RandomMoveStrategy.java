package retry;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private final Random random = new Random();

    @Override
    public boolean isMoveCondition() {
        if (isMoveNumber()) {
            return true;
        }
        return false;
    }

    private boolean isMoveNumber() {
        return random.nextInt(9) >= 4;
    }
}
