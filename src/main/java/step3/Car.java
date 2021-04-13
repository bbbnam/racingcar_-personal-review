package step3;

import java.util.Objects;

public class Car {

    private final Position position;

    public Car(int position) {
        this.position = new Position(position);

    }

    public Car move(MoveCondition condition) {
        if (condition.isMovable()) {
            position.increase();
        }
        return this;
    }

    public Position getPostion() {
        return position;
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
