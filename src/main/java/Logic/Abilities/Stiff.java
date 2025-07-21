package Logic.Abilities;

public class Stiff extends Ability{
    public Stiff(String color){
        super("Stiff", color, "When blocking, reduce damage by 1 damage (0.5 hearts). Will not reduce damage to below 1.");
    }
}
