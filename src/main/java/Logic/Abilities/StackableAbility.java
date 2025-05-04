package Logic.Abilities;

public abstract class StackableAbility extends Ability {
    private int level;
    private final int maxLevel;
    public StackableAbility(String name, String color, String description, int level, int maxLevel) {
        super(name, color, description);
        this.level = level;
        this.maxLevel = maxLevel;
    }
    public int getLevel() {
        return level;
    }
    public int getMaxLevel() {
        return maxLevel;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
