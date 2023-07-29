package baseball.domain;

import baseball.exceptions.BaseBallsMaxCountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseBallsTest {

    private BaseBalls baseBalls;

    @BeforeEach
    void setUp() {
        baseBalls = new BaseBalls();
        baseBalls.addBall(BaseBall.from(1));
        baseBalls.addBall(BaseBall.from(2));
        baseBalls.addBall(BaseBall.from(3));
    }

    @Test
    void 야구공_컨테이너_생성_테스트() {
        BaseBalls baseBalls = new BaseBalls();
        baseBalls.addBall(BaseBall.from(1));
        baseBalls.addBall(BaseBall.from(2));
        baseBalls.addBall(BaseBall.from(3));
    }

    @Test
    void 야구공_컨테이너_생성_실패_테스트() {
        assertThatThrownBy(()-> baseBalls.addBall(BaseBall.from(4)))
                .isInstanceOf(BaseBallsMaxCountException.class)
                .hasMessageContaining("야구공을 3개 이하로 추가해주세요.");
    }

    @Test
    void 야구공_컨테이너_공꺼내기_테스트() {
        List<BaseBall> balls = baseBalls.getBalls();
        assertThat(balls.isEmpty()).isFalse();
        assertThat(balls).isNotNull();
    }

    @Test
    void 야구공_컨테이너_공이_존재하는지_테스트() {
        assertFalse(baseBalls.notContainsBall(BaseBall.from(1)));
        assertFalse(baseBalls.notContainsBall(BaseBall.from(3)));
        assertTrue(baseBalls.notContainsBall(BaseBall.from(4)));
    }
}
