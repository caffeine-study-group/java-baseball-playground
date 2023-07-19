package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
}
