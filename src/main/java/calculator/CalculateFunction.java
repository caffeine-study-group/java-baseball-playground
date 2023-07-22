package calculator;

@FunctionalInterface
public interface CalculateFunction<T, R> {
    R apply(T t1, T t2);
}
