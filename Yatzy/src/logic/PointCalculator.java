package logic;

import yatzy.HandType;
import yatzy.YatzyHand;

/**
 *
 * @author Sebastian Björkqvist
 */
public class PointCalculator {

    public int calculatePoints(YatzyHand hand, HandType type) {
        switch (type) {
            case ONES:
                break;
            case TWOS:
                break;
            case THREES:
                break;
            case FOURS:
                break;
            case FIVES:
                break;
            case SIXES:
                break;
            case ONE_PAIR:
                break;
            case TWO_PAIR:
                break;
            case THREE_OF_A_KIND:
                break;
            case FOUR_OF_A_KIND:
                break;
            case SMALL_STRAIGHT:
                break;
            case LARGE_STRAIGHT:
                break;
            case FULL_HOUSE:
                break;
            case CHANCE:
                break;
            case YATZY:
                break;
            default:
                throw new IllegalArgumentException("Invalid hand type!");
        }
        return -1;
    }
    
    private int calculateSame(YatzyHand hand, int value) {
        return -1;
    }
    
    private int calculatePair(YatzyHand hand) {
        return -1;
    }
    
    private int calculateTwoPair(YatzyHand hand) {
        return -1;
    }  
    
    private int calculateThreeOfAKind(YatzyHand hand) {
        return -1;
    }  
    
    private int calculateFourOfAKind(YatzyHand hand) {
        return -1;
    }  
    
    private int calculateSmallStraight(YatzyHand hand) {
        return -1;
    }          
    
    private int calculateLargeStraight(YatzyHand hand) {
        return -1;
    }    
    
    private int calculateFullHouse(YatzyHand hand) {
        return -1;
    }         
    
    private int calculateChance(YatzyHand hand) {
        return -1;
    }   
    
    private int calculateYatzy(YatzyHand hand) {
        return -1;
    }   
    
}
