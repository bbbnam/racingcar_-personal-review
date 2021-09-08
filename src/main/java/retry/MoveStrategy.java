package retry;

@FunctionalInterface
public interface MoveStrategy {
    boolean isMoveCondition();
}
