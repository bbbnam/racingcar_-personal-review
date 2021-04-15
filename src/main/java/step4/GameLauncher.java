package step4;

import step4.domain.*;
import step4.service.GameConsole;
import step4.view.InputView;
import step4.view.ResultView;

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
