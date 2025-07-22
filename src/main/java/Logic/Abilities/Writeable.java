package Logic.Abilities;

public class Writeable extends StackableAbility{
    public Writeable(int level, String color){
        super("Writeable", color, "+" + level + " modifier slots.", level, 2);
    }
}
