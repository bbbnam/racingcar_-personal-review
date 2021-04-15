package step3.view;

import java.util.Scanner;

public class InputView {

    private static InputView inputView;
    private final Scanner scanner;

    private InputView() {
        this.scanner = new Scanner(System.in);
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public String inputCarsCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextLine();
    }

    public String inputTryNumbers() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextLine();
    }
}
