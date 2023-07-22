package calculator;

import java.util.HashMap;
import java.util.Map;

public class StringCalculator implements Calculator {
    private static final String BLANK_OR_NULL_ERROR_MESSAGE = "공백 또는 null은 입력할 수 없습니다.";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final Map<String, CalculateFunction<Long, Long>> calculateFunctions = new HashMap<>();

    static {
        CalculateFunctionImpl calculateFunction = new CalculateFunctionImpl();
        calculateFunctions.put(PLUS, calculateFunction::plus);
        calculateFunctions.put(MINUS, calculateFunction::minus);
        calculateFunctions.put(MULTIPLY, calculateFunction::multiply);
        calculateFunctions.put(DIVIDE, calculateFunction::divide);
    }

    @Override
    public long calculate(String input) {
        blankOrNullCheck(input);
        StringCalculatorTokens<Long> StringCalculatorTokens = new StringCalculatorTokens<>(input);
        return StringCalculatorTokens.calc(calculateFunctions);
    }

    private void blankOrNullCheck(String input) throws IllegalArgumentException {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException(BLANK_OR_NULL_ERROR_MESSAGE);
        }
    }
}
