package Logic.Abilities;

public class Insatiable extends Ability{
    public Insatiable(String color) {
        super("Insatiable", color, "Hits after the first will deal progressively more bonus damage but also consume more and more durability.\nUsing the tool adds a level of insatiable for 15 seconds, limited to 10 levels. Increases speed and damage by (level / 3).");
    }
}
