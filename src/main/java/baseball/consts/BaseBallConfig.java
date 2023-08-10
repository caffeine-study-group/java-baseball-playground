package baseball.consts;

public class BaseBallConfig {
    public static final int BASE_BALL_SIZE = 3;
    public static final int BASE_BALL_MIN = 1;
    public static final int BASE_BALL_MAX = 9;

    public enum GameStatus {
        PLAYING, END
    }

    public enum RetryStatus {
        NEW_GAME(1), GAME_END(2);

        public final int status;

        RetryStatus(int status) {
            this.status = status;
        }
    }
}
