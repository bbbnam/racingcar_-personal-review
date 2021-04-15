package step4.view;

import step4.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static ResultView resultView;

    private ResultView() {}

    public static ResultView getInstance() {
        if (resultView == null) {
            resultView = new ResultView();
        }
        return resultView;
    }

    public void drawGameResult(List<Cars> results) {
        System.out.println(results.stream()
                .map(cars -> cars.drawAll())
                .collect(Collectors.joining("\n\n")));

    }
}
