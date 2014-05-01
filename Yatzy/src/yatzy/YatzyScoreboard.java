package yatzy;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logic.IPointCalculator;
import logic.PointCalculator;

/**
 * Class that keeps track of the scores of players in a game.
 *
 * @author Sebastian Björkqvist
 */
public class YatzyScoreboard implements IYatzyScoreboard {

    private final List<Player> players;
    private final IPointCalculator calculator;
    private final Map<Player, Map<HandType, Integer>> scores;

    public YatzyScoreboard(List<Player> players) {
        this.players = new ArrayList<>(players);
        this.calculator = new PointCalculator();
        this.scores = new HashMap<>();
        for (Player p : players) {
            scores.put(p, new EnumMap<HandType, Integer>(HandType.class));
        }
    }

    @Override
    public int putHandToPlace(Player player, IYatzyHand hand, HandType type) {
        if (!players.contains(player)) {
            throw new IllegalArgumentException("Player " + player + " not found!");
        }
        if (!type.isPlayable()) {
            throw new IllegalArgumentException("Hand type " + type.getName() + " isn't playable!");
        }
        Map<HandType, Integer> playerScores = scores.get(player);
        if (playerScores.get(type) != null) {
            throw new IllegalStateException("Place " + type.getName() + " already taken for player " + player);
        }
        Integer points = calculator.calculatePoints(hand, type);
        
        playerScores.put(type, points);
        checkBonus(player);
        updateTotal(player);
        
        return points;
    }

    @Override
    public int getScoreAtPlace(Player player, HandType type) {
        if (!players.contains(player)) {
            throw new IllegalArgumentException("Player " + player + " not found!");
        }        
        
        return -1;
    }

    @Override
    public int getTotalScore(Player player) {
        if (!players.contains(player)) {
            throw new IllegalArgumentException("Player " + player + " not found!");
        }        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void checkBonus(Player player) {
        int upperSum = 0;
        
    }

    private void updateTotal(Player player) {
    }

}
