package step5.controller;

import step5.domain.Cars;
import step5.domain.InputNumber;
import step5.domain.MoveStratgy;
import step5.domain.RandomGenerator;
import step5.service.GameConsole;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.List;

public class GameLauncher {
    private static final InputView inputView = InputView.getInstance();
    private static final ResultView resultView = ResultView.getInstance();

    public static void main(String[] args) {
        String carNames = inputView.inputCarsName();
        InputNumber tryNumbers = InputNumber.of(inputView.inputTryNumbers());

        GameConsole gameConsole = GameConsole.of(carNames, tryNumbers.getInt());
        RandomGenerator randomGenerator = new RandomGenerator();

        List<Cars> results = gameConsole.start(new MoveStratgy(randomGenerator));

        resultView.drawGameResult(results);
    }
}
