package yatzy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Björkqvist
 */
public class YatzyHand implements IYatzyHand {

    private final List<Die> dice;

    public YatzyHand(List<Die> dice) {
        if (dice == null) {
            throw new IllegalArgumentException("Dice list is null!");
        }
        if (dice.size() != 5) {
            throw new IllegalArgumentException("There must be five dice");
        }
        this.dice = dice;
    }

    @Override
    public List<Die> getDice() {
        return dice;
    }
    
    @Override
    public void resetHand() {
        for (Die d: dice) {
            d.resetDie();
        }
    }
    
    @Override
    public List<Integer> getDiceValues() {
        List<Integer> values = new ArrayList<>();
        for (Die d: dice) {
            values.add(d.getValue());
        }
        return values;
    }
    

}
