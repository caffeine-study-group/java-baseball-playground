package baseball.domain;

import baseball.consts.BaseBallConfig;
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

    public void start() {
        setUp();

        JudgementResult judgementResult;

        do {
            judgementResult = judgement.judgement(randomBall, inputView.userInputScanner());
            outputView.printJudgementResult(judgementResult);
        } while(judgementResult.getGameStatus().equals(BaseBallConfig.GameStatus.PLAYING));
    }

    private void setUp() {
        randomBall = generator.numberGenerate();
    }
}
