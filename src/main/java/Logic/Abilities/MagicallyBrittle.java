package Logic.Abilities;

public class MagicallyBrittle extends Ability{
    public MagicallyBrittle(String color) {
        super("Magically Brittle", color, "Adds a chance for the tool to break upon durability lost. (Either 1/100 or 1/(Max Durability*Max Durability, which ever is lower).");
    }
}
