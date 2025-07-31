package Logic.Abilities;

public abstract class Ability implements Comparable<Ability>{

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

    @Override
    public String toString() {
        return getName() + " - " + getDescription();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ability) {
            return name.equals(((Ability) obj).name);
        }
        return false;
    }
    public int compareTo(Ability ability) {
        return name.compareTo(ability.name);
    }

}
