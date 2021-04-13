package step3;

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
