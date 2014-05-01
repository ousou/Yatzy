package yatzy;

/**
 *
 * @author Sebastian Björkqvist
 */
public interface IYatzyScoreboard {

    /**
     * Deposits the points from a hand to the given place.
     * 
     * @param hand Hand to deposit
     * @param type Hand type, i.e. place on scoreboard
     * @return The number of points given.
     * @throws IllegalStateException If the place is already taken.
     */
    int putHandToPlace(IYatzyHand hand, HandType type);
}
