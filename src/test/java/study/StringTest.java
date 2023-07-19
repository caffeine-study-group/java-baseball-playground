package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void 요구사항1() {
        // give
        String input = "1,2";

        // when
        String[] splitStrings = input.split(",");

        // then
        assertThat(splitStrings).containsExactly("1", "2");
    }

    @Test
    void 요구사항1_1() {
        // give
        String input = "1";

        // when
        String[] splitStrings = input.split(",");

        // then
        assertThat(splitStrings).contains("1");
    }
    @Test
    void 요구사항2() {
        // given
        String input = "(1,2)";

        // when
        String actual = input.substring(1, input.length() - 1);

        // then
        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("요구사항3 - charAt exception")
    @Test
    void exceptionTest() {
        // given
        String input = "abc";
        int index = -1;

        // when then
        assertThatThrownBy(() ->  input.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index);
    }
}
