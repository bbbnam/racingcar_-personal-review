package step4.view;

import java.util.Scanner;

public class InputView {

    private static final InputView INSTANCE = new InputView();
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() { }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public int enterCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return SCANNER.nextInt();
    }

    public int enterTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }
}
