package step3;

public class Car {

    private Position position;

    public Car(Position position) {
        this.position = position;
    }

    public Position move(MoveCondition condition) {
        /*if (condition.isMovable()) {

        }*/
        return new Position(1);
    }
}
