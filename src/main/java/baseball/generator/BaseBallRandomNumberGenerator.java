package baseball.generator;

import baseball.consts.BaseBallConfig;
import baseball.domain.BaseBall;
import baseball.domain.BaseBalls;
import baseball.utils.RandomUtils;

public class BaseBallRandomNumberGenerator implements BaseBallNumberGenerator {

    @Override
    public BaseBalls numberGenerate() {
        BaseBalls baseBalls = new BaseBalls();

        while (baseBalls.getBalls().size() < BaseBallConfig.BASE_BALL_SIZE) {
            addBaseBall(baseBalls);
        }

        return baseBalls;
    }

    private void addBaseBall(BaseBalls baseBalls) {
        int randomNum = RandomUtils.getRandomNumber(BaseBallConfig.BASE_BALL_MIN, BaseBallConfig.BASE_BALL_MAX);
        BaseBall baseBall = BaseBall.from(randomNum);

        if (baseBalls.notContainsBall(baseBall)) {
            baseBalls.addBall(baseBall);
        }
    }
}
