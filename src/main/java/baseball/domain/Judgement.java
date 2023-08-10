package baseball.domain;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Judgement {

    public JudgementResult judgement(BaseBalls criteria, BaseBalls userInput) {
        int ballCount = containBallCount(criteria, userInput);
        int strikeCount = containStrikeCount(criteria, userInput);

        return new JudgementResult(ballCount, strikeCount);
    }

    private int containBallCount(BaseBalls criteria, BaseBalls userInput) {
        return IntStream.range(0, criteria.size())
                        .map(index -> judgementBall(criteria, userInput, index))
                        .reduce(0, Integer::sum);
    }

    private int containStrikeCount(BaseBalls criteria, BaseBalls userInput) {
        return IntStream.range(0, criteria.size())
                .map(index -> judgementStrike(criteria.getByIndex(index), userInput.getByIndex(index)))
                .reduce(0, Integer::sum);
    }

    private int judgementBall(BaseBalls criteria, BaseBalls userInput, int index) {
        int strike = judgementStrike(criteria.getByIndex(index), userInput.getByIndex(index));
        if (strike > 0) {
            return 0;
        }

        if (criteria.containsBall(userInput.getByIndex(index))) {
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
