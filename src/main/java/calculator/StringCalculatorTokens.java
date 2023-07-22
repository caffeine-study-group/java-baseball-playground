package calculator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

public class StringCalculatorTokens {
    LinkedList<String> list  = new LinkedList<>();
    public StringCalculatorTokens(String input) {
        Collections.addAll(list, input.split(" "));
    }

    public Long calc(Map<String, CalculateFunction<Long, Long>> calculateMethods) {
        loop(calculateMethods);
        return Long.parseLong(list.getFirst());
    }

    private void loop(Map<String, CalculateFunction<Long, Long>> calculateMethods) {
        while (list.size() > 1) {
            Long v1 = Long.parseLong(list.pop());
            String symbol = list.pop();
            Long v2 = Long.parseLong(list.pop());
            list.addFirst(calculateMethods.get(symbol).apply(v1, v2).toString());
        }
    }
}
