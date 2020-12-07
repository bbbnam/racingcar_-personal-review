package step3.domain;

import java.util.Objects;

public class Car {

    private final int position;

    public Car(int position) {
        this.position = position;
    }

    public int addPosition() {
        return position + 1;
    }

    public int getPosition() {
        return position;
    }

    public Car move(MoveStrategy moveStrategy) {
        if(moveStrategy.isMove()) {
            return new Car(addPosition());
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public void print() {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
