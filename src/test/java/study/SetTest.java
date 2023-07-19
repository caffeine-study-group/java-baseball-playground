package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.opentest4j.AssertionFailedError;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {

        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

    }

    @AfterEach
    void setDown(){
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @Test
    void numbersSetSize(){
        setUp();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3"})
    void isBlank_shouldReturnTrueForNullOrBlankString(String input){

        assertThat(numbers).equals(input);

    }

    @ParameterizedTest
    @CsvSource(value = {"1:1","2:2","3:3","4:false","5:false"}, delimiter = ':')
    void toLowerCase(String input, String expected){

        assertThat(input).isEqualTo(expected);

    }



}
