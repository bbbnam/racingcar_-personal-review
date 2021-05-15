package step5.view;

import step5.domain.Car;
import step5.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private static ResultView resultView;

    private ResultView() {}

    public static ResultView getInstance() {
        if (resultView == null) {
            resultView = new ResultView();
        }
        return resultView;
    }

    public void printRecords(List<Cars> records) {
        for (Cars cars : records) {
            printCarPosition(cars.getCars());
        }
    }

    private void printCarPosition(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(String.format("%s : %s \n", car.getName(), convertToBar(car.getPosition())));
        }
        System.out.println(stringBuilder.toString());
    }

    private String convertToBar(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.getName());
        }
        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }
}
