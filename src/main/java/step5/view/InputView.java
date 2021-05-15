package step5.view;

import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

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

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputNames = scanner.nextLine();
        return convertToList(split(inputNames));
    }

    public int inputTryNumbers() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private List<String> convertToList(String[] split) {
        return asList(split);
    }

    private String[] split(String inputNames) {
        return inputNames.split(",");
    }
}
