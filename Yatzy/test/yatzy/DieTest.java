package yatzy;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Sebastian Björkqvist
 */
public class DieTest {

    public DieTest() {
    }

    @Test
    public void testCreateDieWithValue() {
        Die die = new Die(5);
        assertEquals(5, die.getValue());
        assertFalse(die.isLocked());
    }
    
    @Test
    public void testCreateDieWithoutValue() {
        Die die = new Die();
        assertEquals(0, die.getValue());
        assertFalse(die.isLocked());        
    }    
    
    @Test
    public void testThrowLockedDie() {
        Die die = new Die(4);
        assertFalse(die.isLocked());        
        die.toggleLock();
        assertTrue(die.isLocked());
        
        for (int i = 0; i < 100; i++) {
            assertEquals(4, die.throwDie());
        }
        
        assertEquals(4, die.getValue());
    }
    
    @Test
    public void testThrowDie() {
        Die die = new Die();
        
        for (int i = 0; i < 1000; i++) {
            int value = die.throwDie();
            assertTrue(value > 0);
            assertTrue(value < 7);
        }
    }
}