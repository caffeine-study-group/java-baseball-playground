package calculator;

public class Calculator {

    private static final Integer ZERO = 0;
    private static final Integer INDEX_INTERVAL = 2;

    private Calculator() {}

    public static int calculate(String input) {
        String[] array = StringSplitter.split(input);
        int sum = Integer.parseInt(array[ZERO]);
        for (int i = 1; i < array.length; i += INDEX_INTERVAL) {
            sum = calculator(sum , array[i], Integer.parseInt(array[i + 1]));
        }
        return sum;
    }

    private static int calculator(int firstOperand, String operator, int secondOperand) {
        return Operator.of(operator).operate(firstOperand, secondOperand);
    }
}
