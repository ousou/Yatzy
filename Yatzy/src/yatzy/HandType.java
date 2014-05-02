package yatzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sebastian Björkqvist
 */
public enum HandType {
    
    ONES("Ones", true),
    TWOS("Twos", true),
    THREES("Threes", true),
    FOURS("Fours", true),
    FIVES("Fives", true),
    SIXES("Sixes", true),
    UPPER_SUM("Upper sum", false),
    BONUS("Bonus", false),
    ONE_PAIR("One pair", true),
    TWO_PAIR("Two pair", true),
    THREE_OF_A_KIND("Three of a kind", true),
    FOUR_OF_A_KIND("Four of a kind", true),
    SMALL_STRAIGHT("Small straight", true),
    LARGE_STRAIGHT("Large straight", true),
    FULL_HOUSE("Full house", true),
    CHANCE("Chance", true),
    YATZY("Yatzy", true),
    TOTAL("Total", false);
    
    private final boolean playable;
    private final String name;

    private HandType(String name, boolean playable) {
        this.name = name;
        this.playable = playable;
    }
    
    public static List<HandType> getAllHandTypes() {
        return new ArrayList<>(Arrays.asList(values()));
    }
    
    public static List<HandType> getAllPlayableHandTypes() {
        List<HandType> playableTypes = new ArrayList<>(Arrays.asList(values()));
        playableTypes.remove(HandType.UPPER_SUM);
        playableTypes.remove(HandType.BONUS);
        playableTypes.remove(HandType.TOTAL);
        return playableTypes;
    }
    
    public static List<HandType> getUpperHandTypes() {
        List<HandType> upperHandTypes = new ArrayList<>();
        upperHandTypes.add(HandType.ONES);
        upperHandTypes.add(HandType.TWOS);
        upperHandTypes.add(HandType.THREES);
        upperHandTypes.add(HandType.FOURS);
        upperHandTypes.add(HandType.FIVES);
        upperHandTypes.add(HandType.SIXES);
        
        return upperHandTypes;
    }

    public boolean isPlayable() {
        return playable;
    }

    public String getName() {
        return name;
    }
    
    
}
