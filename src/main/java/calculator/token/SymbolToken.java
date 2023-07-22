package calculator.token;

public class SymbolToken implements Token {
    String symbol;

    public SymbolToken(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getValue() {
        return this.symbol;
    }
}
