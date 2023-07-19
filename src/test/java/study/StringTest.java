package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc";

        String numStr = "1,2";
        String[] splitNum = numStr.split(",");
        String[] splitFirstNum = new String[]{splitNum[0]};

        assertThat(splitNum).contains("1");
        assertThat(splitNum).contains("2");
        assertThat(splitFirstNum).containsExactly("1");

        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");


        assertThatThrownBy(() -> {
            actual.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size:2");


    }
}
