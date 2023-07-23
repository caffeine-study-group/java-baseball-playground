package calculator;

import java.util.Map;

public class CalculatorImpl<T> implements Calculator {
    private static final String BLANK_OR_NULL_ERROR_MESSAGE = "공백 또는 null은 입력할 수 없습니다.";
    private static final String EMPTY_STRING = "";
    private final Map<String, CalculateFunction<T, T>> calculateFunctions;

    public CalculatorImpl(Map<String, CalculateFunction<T, T>> calculateFunctions) {
        this.calculateFunctions = calculateFunctions;
    }

    @Override
    public T calculate(String input) {
        blankOrNullCheck(input);
        CalculatorTokens CalculatorTokens = new CalculatorTokens(input);
        loop(CalculatorTokens);
        return (T) CalculatorTokens.pop();
    }

    private void blankOrNullCheck(String input) throws IllegalArgumentException {
        if (input == null || EMPTY_STRING.equals(input)) {
            throw new IllegalArgumentException(BLANK_OR_NULL_ERROR_MESSAGE);
        }
    }

    private void loop(CalculatorTokens calculatorTokens) {
        while (calculatorTokens.size() > 1) {
            T v1 = (T) calculatorTokens.pop();
            String symbol = (String) calculatorTokens.pop();
            T v2 = (T) calculatorTokens.pop();
            calculatorTokens.addFirst(calculateFunctions.get(symbol).apply(v1, v2).toString());
        }
    }
}
