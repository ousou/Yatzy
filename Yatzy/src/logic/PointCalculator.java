package logic;

import java.util.Collections;
import java.util.List;
import yatzy.HandType;
import yatzy.IYatzyHand;

/**
 * Calculates points for yatzy hands.
 *
 * @author Sebastian Björkqvist
 */
public class PointCalculator implements IPointCalculator {

    @Override
    public int calculatePoints(IYatzyHand hand, HandType type) {
        switch (type) {
            case ONES:
                return calculateSame(hand, 1);
            case TWOS:
                return calculateSame(hand, 2);
            case THREES:
                return calculateSame(hand, 3);
            case FOURS:
                return calculateSame(hand, 4);
            case FIVES:
                return calculateSame(hand, 5);
            case SIXES:
                return calculateSame(hand, 6);
            case ONE_PAIR:
                return calculatePair(hand);
            case TWO_PAIR:
                return calculateTwoPair(hand);
            case THREE_OF_A_KIND:
                return calculateThreeOfAKind(hand);
            case FOUR_OF_A_KIND:
                return calculateFourOfAKind(hand);
            case SMALL_STRAIGHT:
                return calculateSmallStraight(hand);
            case LARGE_STRAIGHT:
                return calculateLargeStraight(hand);
            case FULL_HOUSE:
                return calculateFullHouse(hand);
            case CHANCE:
                return calculateChance(hand);
            case YATZY:
                return calculateYatzy(hand);
            default:
                throw new IllegalArgumentException("Invalid hand type!");
        }
    }

    private int calculateSame(IYatzyHand hand, int value) {
        int sum = 0;
        for (Integer i : hand.getDiceValues()) {
            if (i == value) {
                sum += value;
            }
        }
        return sum;
    }

    private int calculatePair(IYatzyHand hand) {
        List<Integer> diceValues = getSortedDiceValues(hand);

        for (int i = 0; i < 4; i++) {
            if (diceValues.get(i) == diceValues.get(i + 1)) {
                return 2 * diceValues.get(i);
            }
        }
        return 0;
    }

    private int calculateTwoPair(IYatzyHand hand) {
        List<Integer> diceValues = getSortedDiceValues(hand);

        int firstPair;
        int secondStart;
        // Finding first pair
        if (diceValues.get(0) == diceValues.get(1)) {
            firstPair = diceValues.get(0);
            secondStart = 2;
        } else if (diceValues.get(1) == diceValues.get(2)) {
            firstPair = diceValues.get(1);
            secondStart = 3;
        } else {
            return 0;
        }

        // Finding second pair
        for (int i = secondStart; i < 4; i++) {
            if (diceValues.get(i) == diceValues.get(i + 1)
                    && diceValues.get(i) != firstPair) {
                return 2 * diceValues.get(i) + 2 * firstPair;
            }
        }
        return 0;
    }

    private int calculateThreeOfAKind(IYatzyHand hand) {
        List<Integer> diceValues = getSortedDiceValues(hand);

        for (int i = 0; i < 3; i++) {
            if (diceValues.get(i) == diceValues.get(i + 1)
                    && diceValues.get(i + 1) == diceValues.get(i + 2)) {
                return 3 * diceValues.get(i);
            }
        }
        return 0;
    }

    private int calculateFourOfAKind(IYatzyHand hand) {
        List<Integer> diceValues = getSortedDiceValues(hand);

        for (int i = 0; i < 2; i++) {
            if (diceValues.get(i) == diceValues.get(i + 1)
                    && diceValues.get(i + 1) == diceValues.get(i + 2)
                    && diceValues.get(i + 2) == diceValues.get(i + 3)) {
                return 4 * diceValues.get(i);
            }
        }
        return 0;
    }

    private int calculateSmallStraight(IYatzyHand hand) {
        List<Integer> diceValues = getSortedDiceValues(hand);

        if (diceValues.get(0) != 5) {
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            if (diceValues.get(i) - 1 != diceValues.get(i + 1)) {
                return 0;
            }
        }

        return 15;
    }

    private int calculateLargeStraight(IYatzyHand hand) {
        List<Integer> diceValues = getSortedDiceValues(hand);

        if (diceValues.get(0) != 6) {
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            if (diceValues.get(i) - 1 != diceValues.get(i + 1)) {
                return 0;
            }
        }

        return 20;
    }

    private int calculateFullHouse(IYatzyHand hand) {
        List<Integer> diceValues = getSortedDiceValues(hand);        
        
        int possibleSum = 0;
        int firstValue;
        boolean pairFirst;
        if (diceValues.get(0) == diceValues.get(1)) {
            firstValue = diceValues.get(0);
            if (diceValues.get(0) == diceValues.get(2)) {
                possibleSum += 3 * diceValues.get(0);
                pairFirst = false;
            } else {
                possibleSum += 2 * diceValues.get(0);
                pairFirst = true;
            }
        } else {
            return 0;
        }
        if (pairFirst) {
            if (diceValues.get(2) == diceValues.get(3)
                    && diceValues.get(3) == diceValues.get(4)
                    && firstValue != diceValues.get(2)) {
                possibleSum += 3 * diceValues.get(2);
                return possibleSum;
            }
        } else {
            if (diceValues.get(3) == diceValues.get(4)
                    && firstValue != diceValues.get(3)) {
                possibleSum += 2 * diceValues.get(3);
                return possibleSum;
            }
        }

        return 0;
    }

    private int calculateChance(IYatzyHand hand) {
        int sum = 0;
        for (Integer i : hand.getDiceValues()) {
            sum += i;
        }
        return sum;
    }

    private int calculateYatzy(IYatzyHand hand) {
        List<Integer> values = hand.getDiceValues();
        for (int i = 1; i < 5; i++) {
            if (values.get(i) != values.get(0)) {
                return 0;
            }
        }
        return 50;
    }

    private List<Integer> getSortedDiceValues(IYatzyHand hand) {
        List<Integer> diceValues = hand.getDiceValues();
        Collections.sort(diceValues);
        Collections.reverse(diceValues);
        return diceValues;
    }
}
