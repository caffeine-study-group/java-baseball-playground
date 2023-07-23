package calculator;

import calculator.string.StringCalculatorSymbols;
import calculator.token.LongToken;
import calculator.token.SymbolToken;
import calculator.token.Token;

import java.util.LinkedList;

public class CalculatorTokens {
    private static final String DELIMITER = " ";
    LinkedList<Token> list  = new LinkedList<>();
    public CalculatorTokens(String input) {
        for (String splitStr : input.split(DELIMITER)) {
            list.add(getToken(splitStr));
        }
    }

    private Token getToken(String splitStr) {
        if (StringCalculatorSymbols.contains(splitStr)) {
            return new SymbolToken(splitStr);
        }
        return new LongToken(splitStr);
    }

    public int size() {
        return list.size();
    }

    public Object pop() {
        return list.pop().getValue();
    }

    public void addFirst(String inputStr) {
        list.addFirst(getToken(inputStr));
    }
}
