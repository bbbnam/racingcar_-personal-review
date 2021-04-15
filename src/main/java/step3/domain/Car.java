package step3.domain;

import java.util.Objects;

public class Car {

    private final Position position;

    public Car(int position) {
        this.position = Position.of(position);
    }

    public Car move(MoveCondition condition) {
        int moved = getPostion();
        if (condition.isMovable()) {
            moved = position.increase();
        }
        return new Car(moved);
    }

    public int getPostion() {
        return position.getNowPosition();
    }

    public String drawPostion() {
        return position.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
