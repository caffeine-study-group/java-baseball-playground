package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JudgementTest {
    private Judgement judgement = new Judgement();

    @BeforeEach
    void setUp() {
        this.judgement = new Judgement();
    }

    @Test
    void 심판_테스트_스트라이크_3개() {
        BaseBalls baseBalls = new BaseBalls();
        baseBalls.addBall(BaseBall.from(1));
        baseBalls.addBall(BaseBall.from(2));
        baseBalls.addBall(BaseBall.from(3));
        BaseBalls userInput = new BaseBalls();
        userInput.addBall(BaseBall.from(1));
        userInput.addBall(BaseBall.from(2));
        userInput.addBall(BaseBall.from(3));
        JudgementResult judgementResult = judgement.judgement(baseBalls, userInput);

        assertThat(judgementResult.getStrikeCount()).isEqualTo(3);
    }

    @Test
    void 심판_테스트_볼_3개() {
        BaseBalls baseBalls = new BaseBalls();
        baseBalls.addBall(BaseBall.from(1));
        baseBalls.addBall(BaseBall.from(2));
        baseBalls.addBall(BaseBall.from(3));
        BaseBalls userInput = new BaseBalls();
        userInput.addBall(BaseBall.from(3));
        userInput.addBall(BaseBall.from(1));
        userInput.addBall(BaseBall.from(2));
        JudgementResult judgementResult = judgement.judgement(baseBalls, userInput);

        assertThat(judgementResult.getBallCount()).isEqualTo(3);
    }

    @Test
    void 심판_테스트_볼_2개() {
        BaseBalls baseBalls = new BaseBalls();
        baseBalls.addBall(BaseBall.from(1));
        baseBalls.addBall(BaseBall.from(2));
        baseBalls.addBall(BaseBall.from(3));
        BaseBalls userInput = new BaseBalls();
        userInput.addBall(BaseBall.from(3));
        userInput.addBall(BaseBall.from(2));
        userInput.addBall(BaseBall.from(1));
        JudgementResult judgementResult = judgement.judgement(baseBalls, userInput);

        assertThat(judgementResult.getBallCount()).isEqualTo(2);
    }

    @Test
    void 심판_테스트_스트라이크_2개() {
        BaseBalls baseBalls = new BaseBalls();
        baseBalls.addBall(BaseBall.from(1));
        baseBalls.addBall(BaseBall.from(2));
        baseBalls.addBall(BaseBall.from(3));
        BaseBalls userInput = new BaseBalls();
        userInput.addBall(BaseBall.from(1));
        userInput.addBall(BaseBall.from(2));
        userInput.addBall(BaseBall.from(4));
        JudgementResult judgementResult = judgement.judgement(baseBalls, userInput);

        assertThat(judgementResult.getStrikeCount()).isEqualTo(2);
    }

    @Test
    void 심판_테스트_스트라이크_1개_볼_2개() {
        BaseBalls baseBalls = new BaseBalls();
        baseBalls.addBall(BaseBall.from(1));
        baseBalls.addBall(BaseBall.from(2));
        baseBalls.addBall(BaseBall.from(3));
        BaseBalls userInput = new BaseBalls();
        userInput.addBall(BaseBall.from(1));
        userInput.addBall(BaseBall.from(3));
        userInput.addBall(BaseBall.from(2));
        JudgementResult judgementResult = judgement.judgement(baseBalls, userInput);

        assertThat(judgementResult.getStrikeCount()).isEqualTo(1);
        assertThat(judgementResult.getBallCount()).isEqualTo(2);
    }
}