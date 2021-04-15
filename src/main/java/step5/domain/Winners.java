package step5.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners of(List<Cars> results) {
        return new Winners(findWinner(results));
    }

    private static List<Car> findWinner(List<Cars> results) {
        Cars finalRecords = results.get(results.size() - 1);
        int maxPosition = findMaxPosition(finalRecords);
        List<Car> winners = find(finalRecords, maxPosition);
        return new ArrayList<>(winners);
    }

    private static List<Car> find(Cars finalRecords, int maxPosition) {
        return finalRecords.getCars().stream()
                .filter(car -> maxPosition == car.getPostion())
                .collect(Collectors.toList());
    }

    private static int findMaxPosition(Cars finalRecords) {
        return finalRecords.getCars().stream()
                .mapToInt(car -> car.getPostion())
                .max().getAsInt();
    }

    public List<Car> getWinners() {
        return winners;
    }
}
