package yatzy;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Sebastian Björkqvist
 */
public class YatzyScoreboardTest {

    private YatzyScoreboard scoreboard;
    private List<Player> players;

    public YatzyScoreboardTest() {
    }

    @Before
    public void setUp() {
        players = new ArrayList<>();
        players.add(new Player("One", true));
        players.add(new Player("Two", true));
        players.add(new Player("Three", true));
        scoreboard = new YatzyScoreboard(players);
    }

    @Test
    public void testPutHandToPlace() {
        IYatzyHand hand = createHand(2, 2, 3, 4, 1);

        assertEquals(4, scoreboard.putHandToPlace(players.get(0), hand, HandType.TWOS));
        assertEquals(4, scoreboard.getScoreAtPlace(players.get(0), HandType.TWOS));
        assertEquals(4, scoreboard.getScoreAtPlace(players.get(0), HandType.UPPER_SUM));
        assertEquals(4, scoreboard.getTotalScore(players.get(0)));

        IYatzyHand hand2 = createHand(3, 2, 3, 3, 2);

        assertEquals(13, scoreboard.putHandToPlace(players.get(1), hand2, HandType.FULL_HOUSE));
        assertEquals(13, scoreboard.getScoreAtPlace(players.get(1), HandType.FULL_HOUSE));
        assertEquals(4, scoreboard.getScoreAtPlace(players.get(0), HandType.UPPER_SUM));
        
        IYatzyHand hand3 = createHand(1, 1, 1, 1, 1);
        
        assertEquals(50, scoreboard.putHandToPlace(players.get(1), hand3, HandType.YATZY));
        assertEquals(50, scoreboard.getScoreAtPlace(players.get(1), HandType.YATZY));        
        assertEquals(4, scoreboard.getScoreAtPlace(players.get(0), HandType.UPPER_SUM));
        
        assertEquals(63, scoreboard.getTotalScore(players.get(1)));
        assertEquals(4, scoreboard.getScoreAtPlace(players.get(0), HandType.UPPER_SUM));
    }

    @Test
    public void testPutHandToPlace2() {
        IYatzyHand hand = createHand(2, 2, 3, 4, 1);
        scoreboard.putHandToPlace(players.get(0), hand, HandType.TWOS);

        assertEquals(-1, scoreboard.getScoreAtPlace(players.get(0), HandType.ONES));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutHandToPlace3() {
        IYatzyHand hand = createHand(2, 2, 3, 4, 1);
        scoreboard.putHandToPlace(new Player("Test", true), hand, HandType.TWOS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutHandToPlace4() {
        IYatzyHand hand = createHand(2, 2, 3, 4, 1);
        scoreboard.putHandToPlace(players.get(0), hand, HandType.BONUS);
    }
    
    @Test
    public void testGetTotalScore() {
        assertEquals(0, scoreboard.getTotalScore(players.get(0)));        
        
        IYatzyHand hand = createHand(1, 2, 3, 4, 5);   
        scoreboard.putHandToPlace(players.get(0), hand, HandType.SMALL_STRAIGHT);  
        
        assertEquals(15, scoreboard.getTotalScore(players.get(0)));       
        
        IYatzyHand hand2 = createHand(5, 2, 3, 4, 5);       
        scoreboard.putHandToPlace(players.get(0), hand2, HandType.FIVES);          
        assertEquals(25, scoreboard.getTotalScore(players.get(0)));    
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetTotalScore2() {
        scoreboard.getTotalScore(new Player("JEE", false));
    }
    
    @Test
    public void testGetScoreAtPlace() {
        assertEquals(-1, scoreboard.getScoreAtPlace(players.get(0), HandType.TWO_PAIR));
        IYatzyHand hand = createHand(5, 2, 2, 4, 5);  
        scoreboard.putHandToPlace(players.get(0), hand, HandType.TWO_PAIR);      
        assertEquals(14, scoreboard.getScoreAtPlace(players.get(0), HandType.TWO_PAIR));        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetScoreAtPlace2() {
        scoreboard.getScoreAtPlace(new Player("JEE", false), HandType.ONES);
    }
    
    @Test
    public void testBonus() {
        IYatzyHand hand1 = createHand(1, 1, 1, 4, 5);        
        IYatzyHand hand2 = createHand(2, 2, 2, 4, 1);
        IYatzyHand hand3 = createHand(3, 3, 3, 4, 5);           
        IYatzyHand hand4 = createHand(4, 4, 4, 6, 2);           
        IYatzyHand hand5 = createHand(5, 5, 1, 4, 5);
        IYatzyHand hand6 = createHand(1, 6, 6, 4, 6);           

        scoreboard.putHandToPlace(players.get(0), hand1, HandType.ONES);        
        scoreboard.putHandToPlace(players.get(0), hand2, HandType.TWOS);
        scoreboard.putHandToPlace(players.get(0), hand3, HandType.THREES);
        scoreboard.putHandToPlace(players.get(0), hand4, HandType.FOURS);
        scoreboard.putHandToPlace(players.get(0), hand5, HandType.FIVES);
        scoreboard.putHandToPlace(players.get(0), hand6, HandType.SIXES); 
        
        assertEquals(50, scoreboard.getScoreAtPlace(players.get(0), HandType.BONUS));
        assertEquals(63, scoreboard.getScoreAtPlace(players.get(0), HandType.UPPER_SUM));
        assertEquals(113, scoreboard.getTotalScore(players.get(0)));  
        assertEquals(113, scoreboard.getScoreAtPlace(players.get(0), HandType.TOTAL));        
    }
    
    @Test
    public void testBonus2() {
        IYatzyHand hand1 = createHand(1, 1, 2, 4, 5);        
        IYatzyHand hand2 = createHand(2, 2, 2, 4, 1);
        IYatzyHand hand3 = createHand(3, 3, 3, 4, 5);           
        IYatzyHand hand4 = createHand(4, 4, 4, 6, 2);           
        IYatzyHand hand5 = createHand(5, 5, 1, 4, 5);
        IYatzyHand hand6 = createHand(1, 6, 6, 4, 6);           

        scoreboard.putHandToPlace(players.get(0), hand1, HandType.ONES);        
        scoreboard.putHandToPlace(players.get(0), hand2, HandType.TWOS);
        scoreboard.putHandToPlace(players.get(0), hand3, HandType.THREES);
        scoreboard.putHandToPlace(players.get(0), hand4, HandType.FOURS);
        scoreboard.putHandToPlace(players.get(0), hand5, HandType.FIVES);
        scoreboard.putHandToPlace(players.get(0), hand6, HandType.SIXES); 
        
        assertEquals(0, scoreboard.getScoreAtPlace(players.get(0), HandType.BONUS));
        assertEquals(62, scoreboard.getScoreAtPlace(players.get(0), HandType.UPPER_SUM));
        assertEquals(62, scoreboard.getTotalScore(players.get(0)));  
        assertEquals(62, scoreboard.getScoreAtPlace(players.get(0), HandType.TOTAL));        
    }

    private IYatzyHand createHand(int i1, int i2, int i3, int i4, int i5) {
        List<Die> dice = new ArrayList<>();

        dice.add(new Die(i1));
        dice.add(new Die(i2));
        dice.add(new Die(i3));
        dice.add(new Die(i4));
        dice.add(new Die(i5));

        return new YatzyHand(dice);
    }
}
