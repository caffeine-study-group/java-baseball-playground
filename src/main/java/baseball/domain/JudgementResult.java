package baseball.domain;

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
}
