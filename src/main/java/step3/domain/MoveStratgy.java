package step3.domain;

public class MoveStratgy implements MoveCondition{

    private final int number;

    public MoveStratgy(int number) {
        this.number = number;
    }

    @Override
    public boolean isMovable() {
        if (number >= 4) {
            return true;
        }
        return false;
    }
}
