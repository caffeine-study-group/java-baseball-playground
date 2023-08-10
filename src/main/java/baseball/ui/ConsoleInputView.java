package baseball.ui;

import baseball.consts.BaseBallConfig;
import baseball.consts.BaseBallMsgConst;
import baseball.domain.BaseBall;
import baseball.domain.BaseBalls;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    Scanner scanner;

    public ConsoleInputView() {
        this.scanner = new Scanner(System.in);
    }


    @Override
    public BaseBalls userInputScanner(){
        printInputGuideMsg();

        String input = scanner.nextLine();
        BaseBalls baseBalls = new BaseBalls();
        for (char c : input.toCharArray()) {
            baseBalls.addBall(BaseBall.from(Character.getNumericValue(c)));
        }

        return baseBalls;
    }

    @Override
    public BaseBallConfig.RetryStatus userRetryInputScanner() {
        int input = Integer.parseInt(scanner.nextLine());

        if (input == BaseBallConfig.RetryStatus.NEW_GAME.status) {
            return BaseBallConfig.RetryStatus.NEW_GAME;
        }

        if (input == BaseBallConfig.RetryStatus.GAME_END.status) {
            return BaseBallConfig.RetryStatus.GAME_END;
        }

        System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
        return userRetryInputScanner();
    }

    @Override
    public void reTryQuestion() {
        printInputReTryQuestionMsg();
    }

    private void printInputGuideMsg() {
        System.out.print(BaseBallMsgConst.USER_BASEBALL_REQUEST_MSG);
    }

    private void printInputReTryQuestionMsg() {
        System.out.println(BaseBallMsgConst.GAME_RE_TRY_QUEST_MSG);
    }
}
