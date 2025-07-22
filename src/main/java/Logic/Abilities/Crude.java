package Logic.Abilities;

public class Crude extends StackableAbility{
    public Crude(int level, String color){
        super("Crude", color, (5*level) + "% extra damage against unarmoured targets.", level, 2);
    }
}
