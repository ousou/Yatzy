package logic;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import yatzy.Die;
import yatzy.HandType;
import yatzy.IYatzyHand;
import yatzy.YatzyHand;

/**
 *
 * @author Sebastian Björkqvist
 */
public class PointCalculatorTest {

    private final PointCalculator calculator;
    
    public PointCalculatorTest() {
        this.calculator = new PointCalculator();
    }

    @Test
    public void testCalculateOnes0() {
        IYatzyHand hand = createHand(3, 5, 6, 2, 3);
        assertEquals(0, calculator.calculatePoints(hand, HandType.ONES));
    }

    @Test
    public void testCalculateOnes1() {
        IYatzyHand hand = createHand(4, 5, 1, 2, 2);
        assertEquals(1, calculator.calculatePoints(hand, HandType.ONES));
    }

    @Test
    public void testCalculateOnes2() {
        IYatzyHand hand = createHand(6, 5, 6, 1, 1);
        assertEquals(2, calculator.calculatePoints(hand, HandType.ONES));
    }

    @Test
    public void testCalculateOnes3() {
        IYatzyHand hand = createHand(1, 5, 1, 1, 3);
        assertEquals(3, calculator.calculatePoints(hand, HandType.ONES));
    }

    @Test
    public void testCalculateOnes4() {
        IYatzyHand hand = createHand(1, 1, 4, 1, 1);
        assertEquals(4, calculator.calculatePoints(hand, HandType.ONES));
    }

    @Test
    public void testCalculateOnes5() {
        IYatzyHand hand = createHand(1, 1, 1, 1, 1);
        assertEquals(5, calculator.calculatePoints(hand, HandType.ONES));
    }

    @Test
    public void testCalculateTwos0() {
        IYatzyHand hand = createHand(5, 1, 5, 3, 1);
        assertEquals(0, calculator.calculatePoints(hand, HandType.TWOS));
    }

    @Test
    public void testCalculateTwos1() {
        IYatzyHand hand = createHand(2, 1, 3, 1, 1);
        assertEquals(2, calculator.calculatePoints(hand, HandType.TWOS));
    }

    @Test
    public void testCalculateTwos2() {
        IYatzyHand hand = createHand(2, 6, 2, 1, 6);
        assertEquals(4, calculator.calculatePoints(hand, HandType.TWOS));
    }

    @Test
    public void testCalculateTwos3() {
        IYatzyHand hand = createHand(4, 1, 2, 2, 2);
        assertEquals(6, calculator.calculatePoints(hand, HandType.TWOS));
    }

    @Test
    public void testCalculateTwos4() {
        IYatzyHand hand = createHand(2, 1, 2, 2, 2);
        assertEquals(8, calculator.calculatePoints(hand, HandType.TWOS));
    }

    @Test
    public void testCalculateTwos5() {
        IYatzyHand hand = createHand(2, 2, 2, 2, 2);
        assertEquals(10, calculator.calculatePoints(hand, HandType.TWOS));
    }

    @Test
    public void testCalculateThrees0() {
        IYatzyHand hand = createHand(2, 4, 1, 1, 1);
        assertEquals(0, calculator.calculatePoints(hand, HandType.THREES));
    }

    @Test
    public void testCalculateThrees1() {
        IYatzyHand hand = createHand(2, 4, 6, 3, 1);
        assertEquals(3, calculator.calculatePoints(hand, HandType.THREES));
    }

    @Test
    public void testCalculateThrees2() {
        IYatzyHand hand = createHand(3, 6, 4, 3, 6);
        assertEquals(6, calculator.calculatePoints(hand, HandType.THREES));
    }

    @Test
    public void testCalculateThrees3() {
        IYatzyHand hand = createHand(2, 3, 3, 1, 3);
        assertEquals(9, calculator.calculatePoints(hand, HandType.THREES));
    }

    @Test
    public void testCalculateThrees4() {
        IYatzyHand hand = createHand(3, 3, 5, 3, 3);
        assertEquals(12, calculator.calculatePoints(hand, HandType.THREES));
    }

    @Test
    public void testCalculateThrees5() {
        IYatzyHand hand = createHand(3, 3, 3, 3, 3);
        assertEquals(15, calculator.calculatePoints(hand, HandType.THREES));
    }

    @Test
    public void testCalculateFours0() {
        IYatzyHand hand = createHand(6, 1, 5, 3, 1);
        assertEquals(0, calculator.calculatePoints(hand, HandType.FOURS));
    }

    @Test
    public void testCalculateFours1() {
        IYatzyHand hand = createHand(5, 4, 5, 6, 6);
        assertEquals(4, calculator.calculatePoints(hand, HandType.FOURS));
    }

    @Test
    public void testCalculateFours2() {
        IYatzyHand hand = createHand(2, 4, 5, 3, 4);
        assertEquals(8, calculator.calculatePoints(hand, HandType.FOURS));
    }

    @Test
    public void testCalculateFours3() {
        IYatzyHand hand = createHand(5, 4, 4, 4, 1);
        assertEquals(12, calculator.calculatePoints(hand, HandType.FOURS));
    }

    @Test
    public void testCalculateFours4() {
        IYatzyHand hand = createHand(4, 4, 4, 4, 1);
        assertEquals(16, calculator.calculatePoints(hand, HandType.FOURS));
    }

    @Test
    public void testCalculateFours5() {
        IYatzyHand hand = createHand(4, 4, 4, 4, 4);
        assertEquals(20, calculator.calculatePoints(hand, HandType.FOURS));
    }

    @Test
    public void testCalculateFives0() {
        IYatzyHand hand = createHand(2, 1, 2, 3, 1);
        assertEquals(0, calculator.calculatePoints(hand, HandType.FIVES));
    }

    @Test
    public void testCalculateFives1() {
        IYatzyHand hand = createHand(2, 5, 3, 3, 1);
        assertEquals(5, calculator.calculatePoints(hand, HandType.FIVES));
    }

    @Test
    public void testCalculateFives2() {
        IYatzyHand hand = createHand(1, 5, 5, 6, 1);
        assertEquals(10, calculator.calculatePoints(hand, HandType.FIVES));
    }

    @Test
    public void testCalculateFives3() {
        IYatzyHand hand = createHand(5, 2, 5, 5, 1);
        assertEquals(15, calculator.calculatePoints(hand, HandType.FIVES));
    }

    @Test
    public void testCalculateFives4() {
        IYatzyHand hand = createHand(5, 5, 5, 3, 5);
        assertEquals(20, calculator.calculatePoints(hand, HandType.FIVES));
    }

    @Test
    public void testCalculateFives5() {
        IYatzyHand hand = createHand(5, 5, 5, 5, 5);
        assertEquals(25, calculator.calculatePoints(hand, HandType.FIVES));
    }

    @Test
    public void testCalculateSixes0() {
        IYatzyHand hand = createHand(2, 4, 4, 3, 1);
        assertEquals(0, calculator.calculatePoints(hand, HandType.SIXES));
    }

    @Test
    public void testCalculateSixes1() {
        IYatzyHand hand = createHand(5, 6, 5, 3, 1);
        assertEquals(6, calculator.calculatePoints(hand, HandType.SIXES));
    }

    @Test
    public void testCalculateSixes2() {
        IYatzyHand hand = createHand(6, 6, 5, 3, 1);
        assertEquals(12, calculator.calculatePoints(hand, HandType.SIXES));
    }

    @Test
    public void testCalculateSixes3() {
        IYatzyHand hand = createHand(6, 1, 3, 6, 6);
        assertEquals(18, calculator.calculatePoints(hand, HandType.SIXES));
    }

    @Test
    public void testCalculateSixes4() {
        IYatzyHand hand = createHand(6, 6, 6, 6, 1);
        assertEquals(24, calculator.calculatePoints(hand, HandType.SIXES));
    }

    @Test
    public void testCalculateSixes5() {
        IYatzyHand hand = createHand(6, 6, 6, 6, 6);
        assertEquals(30, calculator.calculatePoints(hand, HandType.SIXES));
    }
    
    @Test
    public void testPair0() {
        IYatzyHand hand = createHand(1, 2, 3, 4, 5);
        assertEquals(0, calculator.calculatePoints(hand, HandType.ONE_PAIR));        
    }
    
    @Test
    public void testPair1() {
        IYatzyHand hand = createHand(4, 5, 1, 2, 2);
        assertEquals(4, calculator.calculatePoints(hand, HandType.ONE_PAIR));        
    }
    
    @Test
    public void testPair2() {
        IYatzyHand hand = createHand(5, 5, 1, 1, 2);
        assertEquals(10, calculator.calculatePoints(hand, HandType.ONE_PAIR));        
    }
    
    @Test
    public void testPair3() {
        IYatzyHand hand = createHand(6, 5, 3, 1, 1);
        assertEquals(2, calculator.calculatePoints(hand, HandType.ONE_PAIR));        
    }
    
    @Test
    public void testPair4() {
        IYatzyHand hand = createHand(1, 3, 1, 3, 1);
        assertEquals(6, calculator.calculatePoints(hand, HandType.ONE_PAIR));        
    }
    
    @Test
    public void testPair5() {
        IYatzyHand hand = createHand(4, 2, 3, 4, 5);
        assertEquals(8, calculator.calculatePoints(hand, HandType.ONE_PAIR));        
    }
    
    @Test
    public void testTwoPair0() {
        IYatzyHand hand = createHand(1, 2, 3, 4, 5);
        assertEquals(0, calculator.calculatePoints(hand, HandType.TWO_PAIR));        
    }
    
    @Test
    public void testTwoPair1() {
        IYatzyHand hand = createHand(4, 5, 1, 2, 2);
        assertEquals(0, calculator.calculatePoints(hand, HandType.TWO_PAIR));        
    }
    
    @Test
    public void testTwoPair2() {
        IYatzyHand hand = createHand(2, 2, 2, 2, 5);
        assertEquals(0, calculator.calculatePoints(hand, HandType.TWO_PAIR));        
    }
    
    @Test
    public void testTwoPair3() {
        IYatzyHand hand = createHand(1, 3, 3, 3, 5);
        assertEquals(0, calculator.calculatePoints(hand, HandType.TWO_PAIR));        
    }
    
    @Test
    public void testTwoPair4() {
        IYatzyHand hand = createHand(3, 2, 3, 2, 5);
        assertEquals(10, calculator.calculatePoints(hand, HandType.TWO_PAIR));        
    }
    
    @Test
    public void testTwoPair5() {
        IYatzyHand hand = createHand(5, 6, 6, 4, 5);
        assertEquals(22, calculator.calculatePoints(hand, HandType.TWO_PAIR));        
    }
    
    @Test
    public void testTwoPair6() {
        IYatzyHand hand = createHand(2, 2, 4, 4, 4);
        assertEquals(12, calculator.calculatePoints(hand, HandType.TWO_PAIR));        
    }
    
    @Test
    public void testThreeOfAKind0() {
        IYatzyHand hand = createHand(6, 2, 3, 6, 5);
        assertEquals(0, calculator.calculatePoints(hand, HandType.THREE_OF_A_KIND));        
    }
    
    @Test
    public void testThreeOfAKind1() {
        IYatzyHand hand = createHand(6, 1, 1, 2, 1);
        assertEquals(3, calculator.calculatePoints(hand, HandType.THREE_OF_A_KIND));        
    }
    
    @Test
    public void testThreeOfAKind2() {
        IYatzyHand hand = createHand(5, 5, 5, 5, 5);
        assertEquals(15, calculator.calculatePoints(hand, HandType.THREE_OF_A_KIND));        
    }
    
    @Test
    public void testThreeOfAKind3() {
        IYatzyHand hand = createHand(4, 1, 4, 2, 4);
        assertEquals(12, calculator.calculatePoints(hand, HandType.THREE_OF_A_KIND));        
    }
    
    @Test
    public void testThreeOfAKind4() {
        IYatzyHand hand = createHand(3, 3, 1, 3, 3);
        assertEquals(9, calculator.calculatePoints(hand, HandType.THREE_OF_A_KIND));        
    }
    
    @Test
    public void testThreeOfAKind5() {
        IYatzyHand hand = createHand(6, 6, 2, 2, 2);
        assertEquals(6, calculator.calculatePoints(hand, HandType.THREE_OF_A_KIND));        
    }
    
    @Test
    public void testFourOfAKind0() {
        IYatzyHand hand = createHand(2, 2, 3, 6, 1);
        assertEquals(0, calculator.calculatePoints(hand, HandType.FOUR_OF_A_KIND));        
    }
    
    @Test
    public void testFourOfAKind1() {
        IYatzyHand hand = createHand(4, 4, 4, 5, 3);
        assertEquals(0, calculator.calculatePoints(hand, HandType.FOUR_OF_A_KIND));        
    }
    
    @Test
    public void testFourOfAKind2() {
        IYatzyHand hand = createHand(4, 4, 1, 4, 4);
        assertEquals(16, calculator.calculatePoints(hand, HandType.FOUR_OF_A_KIND));        
    }
    
    @Test
    public void testFourOfAKind3() {
        IYatzyHand hand = createHand(2, 2, 2, 2, 2);
        assertEquals(8, calculator.calculatePoints(hand, HandType.FOUR_OF_A_KIND));        
    }
    
    @Test
    public void testFourOfAKind4() {
        IYatzyHand hand = createHand(6, 6, 6, 5, 5);
        assertEquals(0, calculator.calculatePoints(hand, HandType.FOUR_OF_A_KIND));        
    }
    
    @Test
    public void testFourOfAKind5() {
        IYatzyHand hand = createHand(6, 3, 6, 6, 6);
        assertEquals(24, calculator.calculatePoints(hand, HandType.FOUR_OF_A_KIND));        
    }
    
    @Test
    public void testFourOfAKind6() {
        IYatzyHand hand = createHand(3, 1, 3, 3, 3);
        assertEquals(12, calculator.calculatePoints(hand, HandType.FOUR_OF_A_KIND));        
    }
    
    @Test
    public void testSmallStraight0() {
        IYatzyHand hand = createHand(2, 2, 3, 6, 1);
        assertEquals(0, calculator.calculatePoints(hand, HandType.SMALL_STRAIGHT));        
    }
    
    @Test
    public void testSmallStraight1() {
        IYatzyHand hand = createHand(6, 5, 4, 3, 2);
        assertEquals(0, calculator.calculatePoints(hand, HandType.SMALL_STRAIGHT));        
    }
    
    @Test
    public void testSmallStraight2() {
        IYatzyHand hand = createHand(1, 5, 4, 3, 2);
        assertEquals(15, calculator.calculatePoints(hand, HandType.SMALL_STRAIGHT));        
    }
    
    @Test
    public void testSmallStraight3() {
        IYatzyHand hand = createHand(1, 2, 4, 3, 5);
        assertEquals(15, calculator.calculatePoints(hand, HandType.SMALL_STRAIGHT));        
    }
    
    @Test
    public void testSmallStraight4() {
        IYatzyHand hand = createHand(5, 4, 3, 2, 1);
        assertEquals(15, calculator.calculatePoints(hand, HandType.SMALL_STRAIGHT));        
    }
    
    @Test
    public void testSmallStraight5() {
        IYatzyHand hand = createHand(2, 4, 3, 1, 5);
        assertEquals(15, calculator.calculatePoints(hand, HandType.SMALL_STRAIGHT));        
    }
    
    @Test
    public void testSmallStraight6() {
        IYatzyHand hand = createHand(5, 5, 3, 4, 2);
        assertEquals(0, calculator.calculatePoints(hand, HandType.SMALL_STRAIGHT));        
    }
    
    @Test
    public void testLargeStraight0() {
        IYatzyHand hand = createHand(2, 2, 3, 6, 1);
        assertEquals(0, calculator.calculatePoints(hand, HandType.LARGE_STRAIGHT));        
    }
    
    @Test
    public void testLargeStraight1() {
        IYatzyHand hand = createHand(5, 4, 3, 2, 6);
        assertEquals(20, calculator.calculatePoints(hand, HandType.LARGE_STRAIGHT));        
    }
    
    @Test
    public void testLargeStraight2() {
        IYatzyHand hand = createHand(6, 5, 4, 3, 2);
        assertEquals(20, calculator.calculatePoints(hand, HandType.LARGE_STRAIGHT));        
    }
    
    @Test
    public void testLargeStraight3() {
        IYatzyHand hand = createHand(2, 5, 3, 4, 6);
        assertEquals(20, calculator.calculatePoints(hand, HandType.LARGE_STRAIGHT));        
    }
    
    @Test
    public void testLargeStraight4() {
        IYatzyHand hand = createHand(2, 6, 4, 6, 5);
        assertEquals(0, calculator.calculatePoints(hand, HandType.LARGE_STRAIGHT));        
    }
    
    @Test
    public void testLargeStraight5() {
        IYatzyHand hand = createHand(3, 4, 5, 6, 2);
        assertEquals(20, calculator.calculatePoints(hand, HandType.LARGE_STRAIGHT));        
    }
    
    @Test
    public void testLargeStraight6() {
        IYatzyHand hand = createHand(1, 2, 3, 4, 5);
        assertEquals(0, calculator.calculatePoints(hand, HandType.LARGE_STRAIGHT));        
    }
    
    @Test
    public void testFullHouse0() {
        IYatzyHand hand = createHand(2, 2, 6, 6, 1);
        assertEquals(0, calculator.calculatePoints(hand, HandType.FULL_HOUSE));        
    }
    
    @Test
    public void testFullHouse1() {
        IYatzyHand hand = createHand(6, 6, 6, 5, 5);
        assertEquals(28, calculator.calculatePoints(hand, HandType.FULL_HOUSE));        
    }
    
    @Test
    public void testFullHouse2() {
        IYatzyHand hand = createHand(6, 6, 6, 6, 6);
        assertEquals(0, calculator.calculatePoints(hand, HandType.FULL_HOUSE));        
    }
    
    @Test
    public void testFullHouse3() {
        IYatzyHand hand = createHand(1, 1, 1, 6, 6);
        assertEquals(15, calculator.calculatePoints(hand, HandType.FULL_HOUSE));        
    }
    
    @Test
    public void testFullHouse4() {
        IYatzyHand hand = createHand(2, 5, 2, 2, 5);
        assertEquals(16, calculator.calculatePoints(hand, HandType.FULL_HOUSE));        
    }
    
    @Test
    public void testFullHouse5() {
        IYatzyHand hand = createHand(4, 3, 3, 4, 4);
        assertEquals(18, calculator.calculatePoints(hand, HandType.FULL_HOUSE));        
    }
    
    @Test
    public void testFullHouse6() {
        IYatzyHand hand = createHand(2, 2, 3, 2, 2);
        assertEquals(0, calculator.calculatePoints(hand, HandType.FULL_HOUSE));        
    }
    
    @Test
    public void testFullHouse7() {
        IYatzyHand hand = createHand(1, 2, 1, 2, 1);
        assertEquals(7, calculator.calculatePoints(hand, HandType.FULL_HOUSE));        
    }
    
    @Test
    public void testChance0() {
        IYatzyHand hand = createHand(2, 2, 6, 6, 1);
        assertEquals(17, calculator.calculatePoints(hand, HandType.CHANCE));        
    }
    
    @Test
    public void testChance1() {
        IYatzyHand hand = createHand(2, 5, 2, 2, 5);
        assertEquals(16, calculator.calculatePoints(hand, HandType.CHANCE));        
    }
    
    @Test
    public void testChance2() {
        IYatzyHand hand = createHand(1, 4, 3, 6, 6);
        assertEquals(20, calculator.calculatePoints(hand, HandType.CHANCE));        
    }
    
    @Test
    public void testChance3() {
        IYatzyHand hand = createHand(4, 3, 3, 3, 2);
        assertEquals(15, calculator.calculatePoints(hand, HandType.CHANCE));        
    }
    
    @Test
    public void testChance4() {
        IYatzyHand hand = createHand(6, 6, 6, 6, 6);
        assertEquals(30, calculator.calculatePoints(hand, HandType.CHANCE));        
    }
    
    @Test
    public void testChance5() {
        IYatzyHand hand = createHand(1, 1, 1, 1, 1);
        assertEquals(5, calculator.calculatePoints(hand, HandType.CHANCE));        
    }
    
    @Test
    public void testChance6() {
        IYatzyHand hand = createHand(1, 2, 3, 4, 5);
        assertEquals(15, calculator.calculatePoints(hand, HandType.CHANCE));        
    }
    
    @Test
    public void testYatzy0() {
        IYatzyHand hand = createHand(4, 2, 6, 6, 2);
        assertEquals(0, calculator.calculatePoints(hand, HandType.YATZY));        
    }
    
    @Test
    public void testYatzy1() {
        IYatzyHand hand = createHand(1, 1, 1, 1, 1);
        assertEquals(50, calculator.calculatePoints(hand, HandType.YATZY));        
    }
    
    @Test
    public void testYatzy2() {
        IYatzyHand hand = createHand(2, 2, 2, 2, 2);
        assertEquals(50, calculator.calculatePoints(hand, HandType.YATZY));        
    }
    
    @Test
    public void testYatzy3() {
        IYatzyHand hand = createHand(3, 3, 3, 3, 3);
        assertEquals(50, calculator.calculatePoints(hand, HandType.YATZY));        
    }
    
    @Test
    public void testYatzy4() {
        IYatzyHand hand = createHand(4, 4, 4, 4, 4);
        assertEquals(50, calculator.calculatePoints(hand, HandType.YATZY));        
    }
    
    @Test
    public void testYatzy5() {
        IYatzyHand hand = createHand(5, 5, 5, 5, 5);
        assertEquals(50, calculator.calculatePoints(hand, HandType.YATZY));        
    }
    
    @Test
    public void testYatzy6() {
        IYatzyHand hand = createHand(6, 6, 6, 6, 6);
        assertEquals(50, calculator.calculatePoints(hand, HandType.YATZY));        
    }
    
    @Test
    public void testYatzy7() {
        IYatzyHand hand = createHand(6, 2, 6, 6, 6);
        assertEquals(0, calculator.calculatePoints(hand, HandType.YATZY));        
    }
    
    @Test
    public void testYatzy8() {
        IYatzyHand hand = createHand(1, 1, 6, 1, 1);
        assertEquals(0, calculator.calculatePoints(hand, HandType.YATZY));        
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