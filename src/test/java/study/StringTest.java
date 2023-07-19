package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split_1() {
        assertThat("1,2".split(",")).contains("1", "2");
    }

    @Test
    void split_2() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void substring_1() {
        String str = "(1,2)";
        int beginIndex = str.indexOf("(");
        int endIndex = str.indexOf(")");
        assertThat(str.substring(beginIndex + 1, endIndex)).isEqualTo("1,2");
    }

    @Test
    void charAt_1() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생 테스트 1")
    void charAt_2() {
        String str = "abc";
        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 발생 테스트 2")
    void charAt_3() {
        String str = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
        .isThrownBy(() -> {
            str.charAt(3);
        }).withMessageMatching("String index out of range: \\d+");
    }
}
