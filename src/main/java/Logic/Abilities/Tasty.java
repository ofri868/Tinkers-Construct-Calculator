package Logic.Abilities;

public class Tasty extends Ability {
    public Tasty(String color) {
        super("Tasty", color, "If player has less than half hunger, 0.2% chance each tick to \"consume\" your tool, removing 100 durability and restoring 1 bar of hunger. When breaking blocks, 0.5% chance to get bacon. When killing mobs, 5% chance to get bacon.");
    }
}
