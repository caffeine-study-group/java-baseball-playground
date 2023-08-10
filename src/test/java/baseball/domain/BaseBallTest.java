package baseball.domain;

import baseball.exceptions.BaseBallBoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest {

    @Test
    void 베이스볼_생성_테스트() {
        for (int i = 1; i < 10; i++){
            BaseBall baseBall = BaseBall.from(i);
            assertTrue(baseBall.getBall() > 0);
            assertTrue(baseBall.getBall() < 10);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 베이스_생성_예외_테스트(int input) {
        assertThatThrownBy(()-> {
            BaseBall baseBall = BaseBall.from(input);
        }).isInstanceOf(BaseBallBoundException.class)
                .hasMessageContaining("공은 1보다 크고 9보다는 작아야 합니다.");
    }

}