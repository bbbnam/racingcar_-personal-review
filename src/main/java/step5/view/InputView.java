package step5.view;

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

    public String inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public String inputTryNumbers() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextLine();
    }
}
