package calculator.string;

import calculator.Calculator;
import calculator.CalculateFunction;
import calculator.CalculatorTokens;

import java.util.HashMap;
import java.util.Map;

public class StringCalculator implements Calculator {
    private static final String BLANK_OR_NULL_ERROR_MESSAGE = "공백 또는 null은 입력할 수 없습니다.";
    private static final Map<String, CalculateFunction<Long, Long>> calculateFunctions = new HashMap<>();

    static {
        for (StringCalculatorSymbols stringCalculatorSymbols: StringCalculatorSymbols.values()) {
            calculateFunctions.put(stringCalculatorSymbols.symbol, stringCalculatorSymbols.calculateFunction);
        }
    }

    @Override
    public long calculate(String input) {
        blankOrNullCheck(input);
        CalculatorTokens<Long> CalculatorTokens = new CalculatorTokens<>(input);
        return CalculatorTokens.calc(calculateFunctions);
    }

    private void blankOrNullCheck(String input) throws IllegalArgumentException {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException(BLANK_OR_NULL_ERROR_MESSAGE);
        }
    }
}
