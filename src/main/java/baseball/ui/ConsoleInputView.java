package baseball.ui;

import baseball.consts.InputMsgConst;
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

    private void printInputGuideMsg() {
        System.out.print(InputMsgConst.USER_BASEBALL_REQUEST_MSG);
    }
}
