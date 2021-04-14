package step3.domain;

import step3.exception.IllegalPositionException;

import java.util.Objects;

public class Position {

    private int position;

    private Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalPositionException();
        }
    }

    public void increase() {
        position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
