package step4.domain;

import java.util.Objects;

public class Car {

    private final CarName carName;
    private final Position position;

    private Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public static Car of(String name) {
        return new Car(CarName.of(name), Position.of(0));
    }

    public static Car of(String name, int position) {
        return new Car(CarName.of(name), Position.of(position));
    }

    public Car move(MoveCondition condition) {
        int moved = getPostion();
        if (condition.isMovable()) {
            moved = position.increase();
        }
        return new Car(carName, Position.of(moved));
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
