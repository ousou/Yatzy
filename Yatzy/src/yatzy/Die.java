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
    private boolean locked;

    public Die() {
        this.random = new SecureRandom();
        this.value = 0;
        this.locked = false;
    }

    public Die(int value) {
        if (value < 1 || value > 6) {
            throw new IllegalArgumentException("Invalid value!");
        }
        this.random = new SecureRandom();
        this.value = value;
        this.locked = false;
    }

    public int throwDie() {
        if (!locked) {
            value = random.nextInt(6) + 1;
        }
        return value;        
    }

    public int getValue() {
        return value;
    }

    public void resetDie() {
        this.value = 0;
    }

    public boolean isLocked() {
        return locked;
    }

    public void toggleLock() {
        locked = !locked;
    }
    
    public void lock() {
        locked = true;
    }
    
    public void unlock() {
        locked = false;
    }
}
