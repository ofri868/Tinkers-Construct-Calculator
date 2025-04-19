package Abilities;

public abstract class Ability {

    private final String name;
    private final String description;
    private final int level;

    Ability(String name, String description, int level) {
        this.name = name;
        this.description = description;
        this.level = level;
    }
    public String getName() { return name; }
    public int getLevel() { return level; }
    public String getDescription() { return description; }
}
