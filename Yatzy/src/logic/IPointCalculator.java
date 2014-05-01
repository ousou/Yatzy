package logic;

import yatzy.HandType;
import yatzy.IYatzyHand;

/**
 *
 * @author Sebastian Björkqvist
 */
public interface IPointCalculator {

    /**
     * Calculates the points for a hand.
     * 
     * @param hand Yatzy hand
     * @param type Type of the hand
     * @return Number of points as an integer
     */
    int calculatePoints(IYatzyHand hand, HandType type);
}
