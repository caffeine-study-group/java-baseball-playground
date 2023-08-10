package baseball.ui;

import baseball.consts.BaseBallMsgConst;
import baseball.domain.JudgementResult;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printJudgementResult(JudgementResult judgementResult) {
        
        if (judgementResult.isBallAndStrike()) {
            System.out.printf("%d볼 %d스트라이크%n", judgementResult.getBallCount(), judgementResult.getStrikeCount());
            return;
        }

        if (judgementResult.isOnlyBall()) {
            System.out.printf("%d볼%n", judgementResult.getBallCount());
            return;
        }

        if (judgementResult.isOnlyStrike()) {
            System.out.printf("%d스트라이크%n", judgementResult.getStrikeCount());
        }
    }

    @Override
    public void printGameEndMsg() {
        System.out.println(BaseBallMsgConst.GAME_END_MSG);
    }


}
