package step3.domain;

import java.util.Objects;

public class Car {

    private final CarName carName;
    private final Position position;

    public Car(String name, int position) {
        this.carName = CarName.of(name);
        this.position = Position.of(position);
    }

    public Car move(MoveCondition condition) {
        int moved = getPostion();
        if (condition.isMovable()) {
            moved = position.increase();
        }
        return new Car("pobi", moved);
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

    public String getCarName() {
        return carName.getName();
    }
}
