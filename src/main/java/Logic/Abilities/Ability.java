package Logic.Abilities;

public abstract class Ability {

    protected final String name;
    protected final String color;
    protected final String description;

    public Ability(String name, String color, String description) {
        this.name = name;
        this.color = color;
        this.description = description;
    }
    public String getName() { return name; }
    public String getColor() { return color; }
    public String getDescription() { return description; }
}
