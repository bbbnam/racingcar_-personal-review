package step5.domain;

public class MoveStratgy implements MoveCondition {

    private final NumberGenerator generator;

    public MoveStratgy(NumberGenerator generator) {
        this.generator = generator;
    }

    @Override
    public boolean isMovable() {
        int number = generator.generate();
        if (number >= 4) {
            return true;
        }
        return false;
    }
}
