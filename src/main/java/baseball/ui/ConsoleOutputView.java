package baseball.ui;

import baseball.consts.BaseBallMsgConst;
import baseball.domain.JudgementResult;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printJudgementResult(JudgementResult judgementResult) {

        if (judgementResult.isBallAndStrike()) {
            System.out.println(String.format("%d볼 %d스트라이트", judgementResult.getBallCount(), judgementResult.getStrikeCount()));
            return;
        }

        if (judgementResult.isOnlyBall()) {
            System.out.println(String.format("%d볼", judgementResult.getBallCount()));
            return;
        }

        if (judgementResult.isOnlyStrike()) {
            System.out.println(String.format("%d스트라이트", judgementResult.getStrikeCount()));
        }
    }

    @Override
    public void printGameEndMsg() {
        System.out.println(BaseBallMsgConst.GAME_END_MSG);
    }


}
