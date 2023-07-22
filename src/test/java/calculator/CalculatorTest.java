package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void 문자열_계산기_공백_OR_NULL_테스트() {
        assertThatThrownBy(() -> {
            calculator.calculate("");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            calculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_계산기_플러스_테스트() {
        assertThat(calculator.calculate("2 + 3")).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3:5", "5 - 3:2", "3 * 5:15", "6 / 2:3"}, delimiter = ':')
    void 문자열_계산기_간단연산_테스트(String input, long expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @Test
    void 문자열_계산기_테스트_1() {
        Calculator calculator = new StringCalculator();
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10L);
    }
}