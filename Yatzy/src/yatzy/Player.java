package yatzy;

/**
 * Represents a yatzy player.
 *
 * @author Sebastian Björkqvist
 */
public class Player {

    private final String name;
    private final boolean human;

    public Player(String name, boolean human) {
        this.name = name;
        this.human = human;
    }

    public boolean isHuman() {
        return human;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", human=" + human + '}';
    }
    
}
