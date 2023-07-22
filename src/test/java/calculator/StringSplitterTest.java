package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringSplitterTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 문자열_분해_테스트_null(String input) {
        assertThatThrownBy(() -> StringSplitter.split(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 올바르지 않습니다.");
    }
}