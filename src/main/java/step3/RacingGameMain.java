package step3;

import step3.domain.RandomStrategy;
import step3.view.InputView;

public class RacingGameMain {

    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        int carCount = inputView.enterCarCount();
        int tryCount = inputView.enterTryCount();

        RacingGame racingGame = new RacingGame(tryCount, carCount);
        Result result = racingGame.progress(new RandomStrategy());
        result.printResult();
    }
}
