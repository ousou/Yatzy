package yatzy;

import java.util.ArrayList;
import java.util.List;

/**
 * Class handling a yatzy game.
 * 
 * @author Sebastian Björkqvist
 */
public class YatzyGame {

    private final List<Player> players;
    private final IYatzyScoreboard scoreboard;
    private final int playerCount;
    private int playerInTurn;
    private List<Die> currentDice;
    private List<Integer> lockedAtThrow;
    private int throwsLeft;
    private int currentRound;
    private static final int MAX_ROUNDS = 15;    
    

    public YatzyGame(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("No players given!");
        }
        this.players = new ArrayList<>(players);
        this.scoreboard = new YatzyScoreboard(players);
        this.playerCount = players.size();
        this.playerInTurn = 0;
        this.throwsLeft = 3;
        this.currentDice = createDice();
        this.lockedAtThrow = createLockList();
        this.currentRound = 0;
    }

    private List<Die> createDice() {
        List<Die> dice = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            dice.add(new Die());
        }
        
        return dice;
    }

    private List<Integer> createLockList() {
        List<Integer> locklist = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            locklist.add(-1);
        }
        
        return locklist;
    }    

    public List<Integer> getCurrentDiceValues() {
        List<Integer> dieValues = new ArrayList<>();
        
        for (Die d : currentDice) {
            dieValues.add(d.getValue());
        }
        
        return dieValues;
    }
    
    public boolean throwDice() {
        if (throwsLeft <= 0) {
            return false;
        }
        
        for (Die d: currentDice) {
            d.throwDie();
        }
        
        throwsLeft--;
        return true;
    }
    
    public Player getPlayerInTurn() {
        return players.get(playerInTurn);
    }

    public int endTurnAndPlaceScore(HandType handType) {
        if (throwsLeft >= 3) {
            throw new RuntimeException("Must throw once before ending turn!");
        }
        YatzyHand hand = new YatzyHand(currentDice);
        
        int points = scoreboard.putHandToPlace(players.get(playerInTurn), hand, handType);
        
        playerInTurn = (playerInTurn + 1) % playerCount;
        throwsLeft = 3;
        resetDice();
        lockedAtThrow = createLockList();
        if (playerInTurn == 0) {
            currentRound++;
        }
        
        return points;
    }
    
    private void resetDice() {
        for (Die d : currentDice) {
            d.resetDie();
        }
        
    }
    
    public boolean gameInProgress() {
        return currentRound < MAX_ROUNDS;
    }
    
    public void lockDie(int dieIndex) {
        if (dieIndex < 0 || dieIndex >= 5) {
            throw new IllegalArgumentException("Die index out of range!");
        }
        if (throwsLeft < 0 || throwsLeft >= 3) {
            return;
        }
        
        currentDice.get(dieIndex).lock();
        lockedAtThrow.set(dieIndex, throwsLeft);
    }
    
    
    public void unlockDie(int dieIndex) {
        if (dieIndex < 0 || dieIndex >= 5) {
            throw new IllegalArgumentException("Die index out of range!");
        }
        if (throwsLeft < 0 || throwsLeft >= 3) {
            return;
        }
        
        if (lockedAtThrow.get(dieIndex) == throwsLeft) {
            currentDice.get(dieIndex).unlock();
        }
    }    
    
    
}
