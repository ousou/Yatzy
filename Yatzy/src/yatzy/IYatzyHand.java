package yatzy;

import java.util.List;

/**
 * Represents a yatzy hand with five dice.
 * 
 * @author Sebastian Björkqvist
 */
public interface IYatzyHand {

    
    List<Die> getDice();
    
    /**
     * Resets all dice.
     */
    void resetHand();
    
    /**
     * Retrieves the values of the dice as integers.
     * 
     * @return 
     */
    List<Integer> getDiceValues();
}
