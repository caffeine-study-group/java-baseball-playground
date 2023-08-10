package baseball;

import baseball.domain.BaseBallGame;
import baseball.domain.BaseBallRandomNumberGenerator;
import baseball.ui.ConsoleInputView;
import baseball.ui.ConsoleOutputView;

public class Application {

    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame(
                new BaseBallRandomNumberGenerator(),
                new ConsoleInputView(),
                new ConsoleOutputView()
        );

        baseBallGame.playBall();
    }
}
