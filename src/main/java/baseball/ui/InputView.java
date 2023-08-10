package baseball.ui;

import baseball.consts.BaseBallConfig;
import baseball.domain.BaseBalls;

public interface InputView {
    BaseBalls userInputScanner();

    BaseBallConfig.RetryStatus userRetryInputScanner();

    void reTryQuestion();
}
