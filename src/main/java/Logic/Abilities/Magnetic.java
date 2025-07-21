package Logic.Abilities;

public class Magnetic extends StackableAbility {
    public Magnetic(int level, String color) {
        super("Magnetic", color, "Item drops are drawn to the player. Range increases with level.", level, 2);
    }
}
