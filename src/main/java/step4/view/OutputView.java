package step4.view;

import step4.domain.Cars;

import java.util.List;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() { }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void print(List<Cars> result) {
        for (Cars cars : result) {
            System.out.print(cars.print());
            System.out.println();
        }
    }
}
