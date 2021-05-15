package step4;

import step4.domain.MoveCondition;

public class TestStratgy implements MoveCondition {

    private final boolean movable;

    public TestStratgy(boolean movable) {
        this.movable = movable;
    }

    @Override
    public boolean isMovable() {
        return movable;
    }
}
