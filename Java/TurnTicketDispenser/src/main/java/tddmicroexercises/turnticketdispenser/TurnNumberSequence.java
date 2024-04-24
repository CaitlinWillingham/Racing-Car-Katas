package tddmicroexercises.turnticketdispenser;

import java.util.HashSet;
import java.util.Set;

public class TurnNumberSequence {
    private static RandomNumberGenerator random;

    private final static Set<Integer> turnNumbers = new HashSet<>();


    public static int getNextTurnNumber() {

        int nextTurnNumber = random.generateRandomNumber(10000);
        while (turnNumbers.contains(nextTurnNumber)) {
            nextTurnNumber = random.generateRandomNumber(10000);
        }

        turnNumbers.add(nextTurnNumber);

        return nextTurnNumber;
    }

    public static void resetPreviousTurnNumbers(){
        turnNumbers.clear();
    }

    public static void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        random = randomNumberGenerator;
    }
}
