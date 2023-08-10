package baseball.domain;

import baseball.consts.BaseBallMsgConst;
import baseball.exceptions.BaseBallsMaxCountException;

import java.util.ArrayList;
import java.util.List;

public class BaseBalls {

    private static final int MAX_BALL_COUNT = 3;

    private final List<BaseBall> balls = new ArrayList<>();

    public void addBall(BaseBall baseBall) {
        if (balls.size() == MAX_BALL_COUNT) {
            throw new BaseBallsMaxCountException(String.format(BaseBallMsgConst.MAX_COUNT_EXCEPTION_MSG, MAX_BALL_COUNT));
        }
        balls.add(baseBall);
    }

    public boolean containsBall(BaseBall baseBall) {
        return balls.contains(baseBall);
    }

    public boolean notContainsBall(BaseBall baseBall) {
        return !balls.contains(baseBall);
    }

    public List<BaseBall> getBalls() {
        return balls;
    }

    public int size() {
        return this.balls.size();
    }

    public BaseBall getByIndex(int index) {
        return this.balls.get(index);
    }
}
