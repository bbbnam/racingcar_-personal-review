package step3;

import java.util.List;

public class Result {

    private final List<Cars> result;

    public Result(List<Cars> result) {
        this.result = result;
    }

    public void printResult() {
        for (Cars cars : result) {
            cars.print();
        }
    }

    public List<Cars> getResult() {
        return result;
    }

    public int getResultSize() {
        return result.size();
    }
}
