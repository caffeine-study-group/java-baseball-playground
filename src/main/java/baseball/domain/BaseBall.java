package baseball.domain;

import baseball.consts.BaseBallConfig;
import baseball.exceptions.BaseBallBoundException;

import java.util.Objects;

public class BaseBall {
    private final int ball;

    private BaseBall(int ball) {
        this.ball = ball;
    }

    public static BaseBall from(int ball) throws BaseBallBoundException {
        if (ball < BaseBallConfig.BASE_BALL_MIN || ball > BaseBallConfig.BASE_BALL_MAX) {
            throw new BaseBallBoundException(String.format("공은 %s보다 크고 %s보다는 작아야 합니다.",
                    BaseBallConfig.BASE_BALL_MIN, BaseBallConfig.BASE_BALL_MAX ));
        }
        return new BaseBall(ball);
    }

    public int getBall() {
        return ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBall baseBall = (BaseBall) o;
        return ball == baseBall.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }
}
