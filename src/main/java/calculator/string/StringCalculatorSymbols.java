package calculator.string;

import calculator.CalculateFunction;

import java.util.HashMap;
import java.util.Map;

public enum StringCalculatorSymbols {
    PLUS("+", StringCalculateFunction::plus),
    MINUS("-", StringCalculateFunction::minus),
    MULTIPLY("*", StringCalculateFunction::multiply),
    DIVIDE("/", StringCalculateFunction::divide);

    public final String symbol;
    public final CalculateFunction<Long, Long> calculateFunction;

    StringCalculatorSymbols(String symbol, CalculateFunction<Long, Long> calculateFunction) {
        this.symbol = symbol;
        this.calculateFunction = calculateFunction;
    }

    public static  Map<String, CalculateFunction<Long, Long>> getCalculateFunctions() {
        Map<String, CalculateFunction<Long, Long>> calculateFunctions = new HashMap<>();
        for (StringCalculatorSymbols stringCalculatorSymbols: StringCalculatorSymbols.values()) {
            calculateFunctions.put(stringCalculatorSymbols.symbol, stringCalculatorSymbols.calculateFunction);
        }
        return calculateFunctions;
    }

    public static boolean contains(String symbol) {
        for (StringCalculatorSymbols e : StringCalculatorSymbols.values()) {
            if (e.symbol.equals(symbol)) {
                return true;
            }
        }

        return false;
    }
}
