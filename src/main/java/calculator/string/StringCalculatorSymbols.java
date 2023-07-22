package calculator.string;

import calculator.CalculateFunction;

public enum StringCalculatorSymbols {
    PLUS("+", StringCalculateFunction::plus),
    MINUS("-", StringCalculateFunction::minus),
    MULTIPLY("*", StringCalculateFunction::multiply),
    DIVIDE("/", StringCalculateFunction::divide);

    final String symbol;
    final CalculateFunction<Long, Long> calculateFunction;

    StringCalculatorSymbols(String symbol, CalculateFunction<Long, Long> calculateFunction) {
        this.symbol = symbol;
        this.calculateFunction = calculateFunction;
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
