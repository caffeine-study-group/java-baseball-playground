package baseball;

import baseball.domain.BaseBall;
import baseball.domain.BaseBalls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BaseBallNumberGeneratorTest {

    private BaseBallRandomNumberGenerator baseBallRandomNumberGenerator;
    private BaseBalls baseBalls;

    @BeforeEach
    void setUp() {
        baseBallRandomNumberGenerator = new BaseBallRandomNumberGenerator();
        baseBalls = baseBallRandomNumberGenerator.numberGenerate();

    }

    @Test
    void 야구게임_랜덤_숫자_생성_테스트() {
        BaseBalls baseBalls = baseBallRandomNumberGenerator.numberGenerate();
        assertThat(baseBalls).isNotNull();
    }

    @Test
    void 생성되는_숫자는_3자리이다() {
        assertThat(baseBalls.getBalls().size()).isEqualTo(3);
    }

    @Test
    void 생성되는_숫자는_1부터_9까지의_수_이다() {
        for (BaseBall baseBall : baseBalls.getBalls()) {
            assertTrue(baseBall.getBall() > 0);
            assertTrue(baseBall.getBall() < 10);
        }
    }

    @Test
    void 생성되는_숫자는_중복이_없어야한다() {
        Set<Integer> set = new HashSet<>();
        for (BaseBall baseBall : baseBalls.getBalls()) {
            set.add(baseBall.getBall());
        }
        assertThat(baseBalls.getBalls().size()).isEqualTo(set.size());
    }
}