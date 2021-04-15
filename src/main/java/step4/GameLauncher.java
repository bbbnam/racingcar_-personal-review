package step4;

import step4.domain.Cars;
import step4.domain.InputNumber;
import step4.domain.MoveStratgy;
import step4.domain.RandomGenerator;
import step4.service.GameConsole;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class GameLauncher {
    private static final InputView inputView = InputView.getInstance();
    private static final ResultView resultView = ResultView.getInstance();

    public static void main(String[] args) {
        InputNumber carsCount = InputNumber.of(inputView.inputCarsCount());
        InputNumber tryNumbers = InputNumber.of(inputView.inputTryNumbers());

        GameConsole gameConsole = GameConsole.of(carsCount.getInt(), tryNumbers.getInt());
        RandomGenerator randomGenerator = new RandomGenerator();

        List<Cars> results = gameConsole.start(new MoveStratgy(randomGenerator));

        resultView.drawGameResult(results);
    }
}
