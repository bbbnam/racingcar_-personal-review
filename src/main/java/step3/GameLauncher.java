package step3;

import step3.domain.*;
import step3.service.GameConsole;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class GameLauncher {
    private static final InputView inputView = InputView.getInstance();
    private static final ResultView resultView = ResultView.getInstance();

    public static void main(String[] args) {
        InputNumber carsCount = InputNumber.of(inputView.inputCarsCount());
        InputNumber tryNumbers = InputNumber.of(inputView.inputTryNumbers());

        GameConsole gameConsole = new GameConsole(carsCount.getInt(), tryNumbers.getInt());
        RandomGenerator randomGenerator = new RandomGenerator();

        List<Cars> results = gameConsole.start(new MoveStratgy(randomGenerator));

        resultView.drawGameResult(results);
    }
}
