package step5.view;

import step5.domain.Cars;
import step5.domain.Winners;

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
        Winners winners = Winners.of(results);
        System.out.print(winners.getWinners().stream()
                                  .map(winner -> winner.getCarName())
                                  .collect(Collectors.joining(", "))+"가 최종 우승했습니다.");
    }
}
