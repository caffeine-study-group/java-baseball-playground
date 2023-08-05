package baseball.domain;

import baseball.consts.BaseBallConfig;

public class JudgementResult {
    private final int ballCount;
    private final int strikeCount;

    public JudgementResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isBallAndStrike() {

        return (strikeCount > 0 && ballCount > 0);
    }

    public boolean isOnlyBall() {

        return (strikeCount == 0 && ballCount > 0);
    }

    public boolean isOnlyStrike() {

        return (strikeCount > 0 && ballCount == 0);
    }

    public BaseBallConfig.GameStatus getGameStatus() {

        if (strikeCount == 3) return BaseBallConfig.GameStatus.END;

        return BaseBallConfig.GameStatus.PLAYING;
    }

}
