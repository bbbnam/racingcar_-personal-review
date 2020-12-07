package step3;

import step3.domain.Cars;

import java.util.List;

public class Result {

    private final List<Cars> result;

    public Result(List<Cars> result) {
        this.result = result;
    }

    public void printResult() {
        for (Cars cars : result) {
            cars.print();
            System.out.println();
        }
    }

    public int getResultSize() {
        return result.size();
    }
}
