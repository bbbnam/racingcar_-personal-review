package step3;

import step3.domain.MoveStrategy;

public class MoveTestStrategy implements MoveStrategy {

    private final boolean moveValue;

    public MoveTestStrategy(boolean moveValue) {
        this.moveValue = moveValue;
    }

    @Override
    public boolean isMove() {
        return moveValue;
    }
}
