package yatzy;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Sebastian Björkqvist
 */
public class YatzyBoardPosition implements IYatzyBoardPosition {

    private List<Die> dice;
    private Map<Player, Map<HandType, Integer>> scores;

    public YatzyBoardPosition(List<Die> dice, Map<Player, Map<HandType, Integer>> scores) {
        this.dice = dice;
        this.scores = scores;
    }
    
    @Override
    public List<Die> getDice() {
        return dice;
    }

    @Override
    public Map<Player, Map<HandType, Integer>> getScores() {
        return scores;
    }

}
