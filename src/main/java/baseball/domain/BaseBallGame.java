package baseball.domain;

import baseball.consts.BaseBallConfig;
import baseball.generator.BaseBallNumberGenerator;
import baseball.ui.InputView;
import baseball.ui.OutputView;

public class BaseBallGame {

    private final BaseBallNumberGenerator generator;

    private final InputView inputView;
    private final OutputView outputView;

    private BaseBalls randomBall;
    private final Judgement judgement;

    public BaseBallGame(BaseBallNumberGenerator generator, InputView inputView, OutputView outputView) {
        this.generator = generator;
        this.inputView = inputView;
        this.outputView = outputView;
        judgement = new Judgement();
    }

    public void playBall() {
        setUp();
        start();
        end();
        retry();
    }

    private void start() {
        JudgementResult judgementResult;

        do {
            judgementResult = judgement.judgement(randomBall, inputView.userInputScanner());
            outputView.printJudgementResult(judgementResult);
        } while(judgementResult.getGameStatus().equals(BaseBallConfig.GameStatus.PLAYING));

    }

    private void end() {
        outputView.printGameEndMsg();

    }

    private void retry() {
        inputView.reTryQuestion();
        if (BaseBallConfig.RetryStatus.NEW_GAME.equals(inputView.userRetryInputScanner())) {
            this.playBall();
        }
    }


    private void setUp() {
        randomBall = generator.numberGenerate();
    }
}
