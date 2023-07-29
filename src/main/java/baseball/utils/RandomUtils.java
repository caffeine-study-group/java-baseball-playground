package baseball.utils;

import java.util.Random;

public class RandomUtils {
    public static int getRandomNumber(int sBound, int eBound) {
        Random random = new Random();

        return random.nextInt(eBound - sBound) + sBound;
    }
}
