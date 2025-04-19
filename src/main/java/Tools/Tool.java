package Tools;
import Abilities.Ability;
import Parts.Part;

import java.util.HashSet;
import java.util.Set;

public abstract class Tool {
    protected final String toolName;
    protected int durability;
    protected double miningSpeed;
    protected double attack;
    protected final Part head;
    protected final Part handle;
    protected Set<Ability> abilities;

    public Tool(String toolName, Part head, Part handle) {
        this.toolName = toolName;
        this.head = head;
        this.handle = handle;
        abilities = new HashSet<>();
        calculateDurability();
        calculateMiningSpeed();
        calculateAttack();
    }
    public String getToolName() { return toolName; }
    public Part getHead() { return head; }
    public Part getHandle() { return handle; }
    public int getDurability() { return durability; }
    public abstract void calculateDurability();
    public double getMiningSpeed() { return miningSpeed; }
    public abstract void calculateMiningSpeed();
    public double getAttack() { return attack; }
    public abstract void calculateAttack();
    public Set<Ability> getAbilities() { return abilities; }
    public void calculateAbilities() {
        abilities.addAll(head.getMaterial().getAbilities());
        abilities.addAll(handle.getMaterial().getAbilities());
    }
}
