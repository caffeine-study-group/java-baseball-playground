package baseball.domain;

public class Judgement {

    public JudgementResult judgement(BaseBalls criteria, BaseBalls userInput) {
        int ballCount = containBallCount(criteria, userInput);
        int strikeCount = containStrikeCount(criteria, userInput);

        return new JudgementResult(ballCount, strikeCount);
    }

    private int containBallCount(BaseBalls criteria, BaseBalls userInput) {
        int result = 0;

        for (int i = 0; i < criteria.getBalls().size(); i++) {
            result += judgementBall(criteria, userInput, i);
        }

        return result;
    }

    private int containStrikeCount(BaseBalls criteria, BaseBalls userInput) {
        int result = 0;

        for (int i = 0; i < criteria.getBalls().size(); i++) {
            result += judgementStrike(criteria.getBalls().get(i), userInput.getBalls().get(i));
        }

        return result;
    }

    private int judgementBall(BaseBalls criteria, BaseBalls userInput, int index) {
        int strike = judgementStrike(criteria.getBalls().get(index), userInput.getBalls().get(index));
        if (strike > 0) {
            return 0;
        }

        if (criteria.containsBall(userInput.getBalls().get(index))) {
            return 1;
        }

        return 0;
    }

    private int judgementStrike(BaseBall criteria, BaseBall userInput) {
        if (criteria.equals(userInput)) {
            return 1;
        }
        return 0;
    }
}
