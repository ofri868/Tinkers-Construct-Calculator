package Logic.Abilities;

public class Vanishing extends StackableAbility {
    public Vanishing(int level, String color) {
        super("vanishing", color, "Chance to teleport enemies away.", level, 3);
    }
}
