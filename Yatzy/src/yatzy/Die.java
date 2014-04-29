package yatzy;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Class representing a die.
 * 
 * @author Sebastian Björkqvist
 */
public class Die {

    private int value;
    private final Random random;

    public Die() {
        this.random = new SecureRandom();
        this.value = 0;        
    }
    
    public Die(int value) {
        if (value < 1 || value > 6) {
            throw new IllegalArgumentException("Invalid value!");
        }
        this.random = new SecureRandom();
        this.value = value;        
    }    

    public int throwDie() {
        value = random.nextInt(6) + 1;
        return value;
    }

    public int getValue() {
        return value;
    }
    
    public void resetDie() {
        this.value = 0;
    }
    
}
