package calculator;

public enum StringCalculatorSymbols {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    final String symbol;

    StringCalculatorSymbols(String symbol) {
        this.symbol = symbol;
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
