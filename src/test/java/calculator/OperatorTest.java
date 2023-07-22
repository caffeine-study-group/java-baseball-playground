package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1:+:3:4"}, delimiter = ':')
    void 더하기(int firstOperand, String operator, int secondOperand, int excepted) {
        assertThat(Operator.of(operator).operate(firstOperand, secondOperand)).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:-:1:1", "2:-:3:-1"}, delimiter = ':')
    void 빼기(int firstOperand, String operator, int secondOperand, int excepted) {
        assertThat(Operator.of(operator).operate(firstOperand, secondOperand)).isEqualTo(excepted);
    }


    @ParameterizedTest
    @CsvSource(value = {"2:*:1:2", "2:*:3:6"}, delimiter = ':')
    void 곱하기(int firstOperand, String operator, int secondOperand, int excepted) {
        assertThat(Operator.of(operator).operate(firstOperand, secondOperand)).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:/:2:1", "6:/:3:2"}, delimiter = ':')
    void 나누기(int firstOperand, String operator, int secondOperand, int excepted) {
        assertThat(Operator.of(operator).operate(firstOperand, secondOperand)).isEqualTo(excepted);
    }

    @Test
    void 나누기를_0으로_하는_경우() {
        assertThatThrownBy(() -> Operator.of("/").operate(2, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다.");
    }
}