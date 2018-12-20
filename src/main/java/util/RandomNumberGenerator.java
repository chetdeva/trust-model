package util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomNumberGenerator {

    public static int generateRandomNumber(int min, int max) {
        Random n = new SecureRandom();
        return n.nextInt(max - min) + min;
    }
}
