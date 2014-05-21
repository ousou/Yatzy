package yatzy;

import java.util.List;
import java.util.Map;

/**
 * Interface representing the current board position.
 * 
 * @author Sebastian Björkqvist
 */
public interface IYatzyBoardPosition {
    
    List<Die> getDice();
    
    Map<Player, Map<HandType, Integer>> getScores();
}
