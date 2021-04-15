package step4.domain;

import step4.exception.IllegalCarNameException;
import step4.exception.IllegalInputException;

import java.util.Objects;

public class CarName {

    private final String carName;

    private CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        checkNullorEmpty(carName);
        checkLength(carName);
    }

    private void checkNullorEmpty(String carName) {
        if(carName == null || carName.trim().isEmpty()) {
            throw new IllegalInputException();
        }
    }

    private void checkLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalCarNameException();
        }
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    public String getName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
