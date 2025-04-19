package Abilities;

public abstract class Ability {

    protected final String name;
    protected final String description;
    protected int level;

    public Ability(String name, String description, int level) {
        this.name = name;
        this.description = description;
        this.level = level;
    }
    public String getName() { return name; }
    public int getLevel() { return level; }
    public String getDescription() { return description; }
    public void setLevel(int level) { this.level = level; }
}
