package calculator;

import calculator.string.StringCalculatorSymbols;
import calculator.token.LongToken;
import calculator.token.SymbolToken;
import calculator.token.Token;

import java.util.LinkedList;
import java.util.Map;

public class CalculatorTokens<T> {
    LinkedList<Token> list  = new LinkedList<>();
    public CalculatorTokens(String input) {
        for (String splitStr : input.split(" ")) {
            list.add(getToken(splitStr));
        }
    }

    private Token getToken(String splitStr) {
        if (StringCalculatorSymbols.contains(splitStr)) {
            return new SymbolToken(splitStr);
        }
        return new LongToken(splitStr);
    }

    public T calc(Map<String, CalculateFunction<T, T>> calculateMethods) {
        loop(calculateMethods);
        return (T) list.getFirst().getValue();
    }

    private void loop(Map<String, CalculateFunction<T, T>> calculateMethods) {
        while (list.size() > 1) {
            T v1 = (T) list.pop().getValue();
            String symbol = (String) list.pop().getValue();
            T v2 = (T) list.pop().getValue();
            list.addFirst(new LongToken(calculateMethods.get(symbol).apply(v1, v2).toString()));
        }
    }
}
