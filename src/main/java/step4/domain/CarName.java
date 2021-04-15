package step4.domain;

import step4.exception.IllegalCarNameException;
import step4.exception.IllegalInputException;

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
}
