package Logic.Abilities;

public class Vanishing extends StackableAbility {
    public Vanishing(int level, String color) {
        super("Vanishing", color, "Chance to teleport enemies away.", level, 3);
    }
}
