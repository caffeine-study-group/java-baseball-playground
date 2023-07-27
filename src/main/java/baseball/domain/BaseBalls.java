package baseball.domain;

import baseball.exceptions.BaseBallsMaxCountException;

import java.util.ArrayList;
import java.util.List;

public class BaseBalls {

    private static final int MAX_BALL_COUNT = 3;

    private List<BaseBall> balls = new ArrayList<>();

    public void addBall(BaseBall baseBall) {
        if (balls.size() == 3) {
            throw new BaseBallsMaxCountException(String.format("야구공을 %s개 이하로 추가해주세요.", MAX_BALL_COUNT));
        }
        balls.add(baseBall);
    }

    public List<BaseBall> getBalls() {
        return balls;
    }
}
