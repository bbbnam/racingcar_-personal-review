package step4.domain;

import step4.exception.IllegalInputException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarNames {

    private final List<CarName> carNames;

    private CarNames(String carNames) {
        validateCarNames(carNames);
        this.carNames = convertToList(split(carNames));
    }

    private void validateCarNames(String carNames) {
        checkNullorEmpty(carNames);
    }

    private void checkNullorEmpty(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalInputException();
        }
    }

    public static CarNames of(String names) {
        return new CarNames(names);
    }

    private static String[] split(String names) {
        return names.split(",");
    }

    private static List<CarName> convertToList(String[] names) {
        return Stream.of(names)
                .map(name -> CarName.of(name))
                .collect(Collectors.toList());
    }

    public List<CarName> getCarNames() {
        return carNames;
    }
}
