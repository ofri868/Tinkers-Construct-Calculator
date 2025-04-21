package Logic.Tools;

import Logic.Parts.ToolPart;
import Logic.Utils.AbilitySet;

public abstract class Tool {
    protected final String toolName;
    protected int durability;
    protected double miningSpeed;
    protected double attack;
    protected final ToolPart head;
    protected final ToolPart handle;
    protected AbilitySet abilities;

    public Tool(String toolName, ToolPart head, ToolPart handle) {
        this.toolName = toolName;
        this.head = head;
        this.handle = handle;
        abilities = new AbilitySet();
        calculateDurability();
        calculateMiningSpeed();
        calculateAttack();
    }
    public String getToolName() { return toolName; }
    public ToolPart getHead() { return head; }
    public ToolPart getHandle() { return handle; }
    public int getDurability() { return durability; }
    public abstract void calculateDurability();
    public double getMiningSpeed() { return miningSpeed; }
    public abstract void calculateMiningSpeed();
    public double getAttack() { return attack; }
    public abstract void calculateAttack();
    public AbilitySet getAbilities() { return abilities; }
    public void calculateAbilities() {
        abilities.addAll(head.getMaterial().getAbilities());
        abilities.addAll(handle.getMaterial().getAbilities());
    }
}
