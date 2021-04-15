package step5.domain;

import step5.exception.IllegalPositionException;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public int increase() {
        this.position += 1;
        return position;
    }

    public int getNowPosition() {
        return position;
    }

    @Override
    public String toString() {
        return Arrays.stream(new String[position])
                .map(position -> "-")
                .collect(Collectors.joining(""));
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
