package Logic.Tools;

import Logic.Parts.ToolPart;
import Logic.Tools.AdvancedTools.Excavator;
import Logic.Tools.AdvancedTools.Hammer;
import Logic.Tools.AdvancedTools.LumberAxe;
import Logic.Tools.AdvancedTools.Scythe;
import Logic.Tools.BasicTools.Hatchet;
import Logic.Tools.BasicTools.Mattock;
import Logic.Tools.BasicTools.Pickaxe;
import Logic.Tools.BasicTools.Shovel;
import Logic.Utils.AbilitySet;

import java.util.List;

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
        calculateAbilities();
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
    @Override
    public String toString() {
        return head.getMaterial().getName() +
                " " + getToolName() + "\n" +
                head + "\n" +
                handle + "\n";
    }
    public static Tool getTool(String toolName, List<ToolPart> parts) {
        return switch (toolName) {
            case "Pickaxe" -> new Pickaxe("Pickaxe", parts.get(0), parts.get(1), parts.get(2));
            case "Shovel" -> new Shovel("Shovel", parts.get(0), parts.get(1));
            case "Hatchet" -> new Hatchet("Hatchet", parts.get(0), parts.get(1));
            case "Mattock" -> new Mattock("Mattock", parts.get(0), parts.get(1), parts.get(2));
            case "Hammer" -> new Hammer("Hammer", parts.get(0), parts.get(1), parts.get(2), parts.get(3));
            case "Excavator" -> new Excavator("Excavator", parts.get(0), parts.get(1), parts.get(2), parts.get(3));
            case "Lumber Axe" -> new LumberAxe("Lumber Axe", parts.get(0), parts.get(1), parts.get(2), parts.get(3));
            case "Scythe" -> new Scythe("Scythe", parts.get(0), parts.get(1), parts.get(2), parts.get(3));
            default -> throw new IllegalArgumentException("tool not found: " + toolName);
        };
    }
}
