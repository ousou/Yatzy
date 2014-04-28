package yatzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sebastian Björkqvist
 */
public enum HandType {
    
    ONES(true),
    TWOS(true),
    THREES(true),
    FOURS(true),
    FIVES(true),
    SIXES(true),
    UPPER_SUM(false),
    BONUS(false),
    ONE_PAIR(true),
    TWO_PAIR(true),
    THREE_OF_A_KIND(true),
    FOUR_OF_A_KIND(true),
    SMALL_STRAIGHT(true),
    LARGE_STRAIGHT(true),
    FULL_HOUSE(true),
    CHANCE(true),
    YATZY(true),
    TOTAL(false);
    
    private final boolean playable;

    private HandType(boolean playable) {
        this.playable = playable;
    }
    
    public static List<HandType> getAllHandTypes() {
        return new ArrayList<>(Arrays.asList(values()));
    }

    public boolean isPlayable() {
        return playable;
    }
    
    
}
