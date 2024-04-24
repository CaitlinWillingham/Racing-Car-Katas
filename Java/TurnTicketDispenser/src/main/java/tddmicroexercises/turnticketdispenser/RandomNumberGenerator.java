package tddmicroexercises.turnticketdispenser;

import java.util.Random;

public class RandomNumberGenerator {
    private static Random random = new Random();

    public int generateRandomNumber(int bound) {
        return random.nextInt(bound);
    }


}
