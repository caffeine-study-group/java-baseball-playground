package baseball.domain;

import baseball.exceptions.BaseBallBoundException;

public class BaseBall {

    private static final int BASE_BALL_MAX = 9;

    private static final int BASE_BALL_MIN = 1;

    private int ball;

    private BaseBall(int ball) {
        this.ball = ball;
    }

    public static BaseBall from(int ball) throws BaseBallBoundException {
        if (ball < BASE_BALL_MIN || ball > BASE_BALL_MAX) {
            throw new BaseBallBoundException(String.format("공은 %s다 크거나 %s보다는 작아야 합니다.",
                                                            BASE_BALL_MIN, BASE_BALL_MAX ));
        }
        return new BaseBall(ball);
    }

    public int getBall() {
        return ball;
    }

}
