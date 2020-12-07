package step3;

import step3.domain.Cars;

import java.util.Collections;
import java.util.List;

public class Result {

    private final List<Cars> result;

    public Result(List<Cars> result) {
        this.result = result;
    }

    public int getResultSize() {
        return result.size();
    }

    public List<Cars> getResult() {
        return Collections.unmodifiableList(result);
    }
}
