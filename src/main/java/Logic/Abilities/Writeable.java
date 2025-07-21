package Logic.Abilities;

public class Writeable extends StackableAbility{
    public Writeable(int level, String color){
        super("writeable", color, "+" + level + " modifier slot.", level, 2);
    }
}
