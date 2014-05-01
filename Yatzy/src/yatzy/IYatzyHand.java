package yatzy;

import java.util.List;

/**
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
