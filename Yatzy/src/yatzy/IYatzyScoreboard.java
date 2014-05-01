package yatzy;

/**
 * Class representing a yatzy scoreboard.
 * 
 * @author Sebastian Björkqvist
 */
public interface IYatzyScoreboard {

    /**
     * Deposits the points from a hand to the given place.
     * 
     * @param player Player that will get the points
     * @param hand Hand to deposit
     * @param type Hand type, i.e. place on scoreboard
     * @return The number of points given.
     * @throws IllegalArgumentException if the player isn't found or if the hand
     * type is non-playable.
     * @throws IllegalStateException if the place is already taken.
     */
    int putHandToPlace(Player player, IYatzyHand hand, HandType type);
    
    /**
     * Returns the score placed at the given place.
     * 
     * @param player
     * @param type Hand type, i.e. place on scoreboard
     * @return The score, -1 if place not yet used.
     * @throws IllegalArgumentException if the player isn't found 
     */
    int getScoreAtPlace(Player player, HandType type);
    
    /**
     * Retrieves the total score for a player.
     * 
     * @param player
     * @return Total score
     * @throws IllegalArgumentException if the player isn't found 
     */
    int getTotalScore(Player player);

}
