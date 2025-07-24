package Logic.Tools;

import Logic.Abilities.Ability;
import Logic.Materials.Material;
import Logic.Parts.ToolParts.*;
import Logic.Parts.ToolParts.Extras.*;
import Logic.Parts.ToolParts.Handles.*;
import Logic.Parts.ToolParts.Heads.*;
import Logic.Tools.AdvancedTools.*;
import Logic.Tools.BasicTools.*;
import Logic.Utils.AbilitySet;
import Logic.Utils.PartType;
import javafx.util.Pair;

import java.util.List;

public abstract class Tool {
    protected final String toolName;
    protected int durability;
    protected double miningSpeed;
    protected double attack;
    protected final Head head;
    protected final Handle handle;
    protected AbilitySet abilities;

    public Tool(String toolName, Head head, Handle handle) {
        this.toolName = toolName;
        this.head = head;
        this.handle = handle;
        abilities = new AbilitySet();
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
    public String getAbilitiesString() {
        StringBuilder abilities = new StringBuilder();
        for (Ability ability : this.abilities) {
            abilities.append(ability.toString()).append("\n");
        }
        return abilities.toString();
    }

    public String getPartsString(){
        return head + "\n" + handle;
    }

    public String getStatsString(){
        return "Durability: " + durability + "\n"
                + "Mining Speed: " + miningSpeed + "\n"
                + "Attack: " + attack + "\n";
    }

    @Override
    public String toString() {
        return head.getMaterial().getName() + " " + getToolName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tool other) {
            return head.equals(other.getHead()) && handle.equals(other.getHandle());
        }
        return false;
    }

    public static Tool getTool(String toolName, List<Pair<PartType, Material>> parts) {
        return switch (toolName) {
            case "Pickaxe" -> new Pickaxe(new PickaxeHead(parts.get(0).getKey(), parts.get(0).getValue()), new ToolBinding(parts.get(1).getKey(), parts.get(1).getValue()), new ToolRod(parts.get(2).getKey(), parts.get(2).getValue()));
            case "Shovel" -> new Shovel(new ShovelHead(parts.get(0).getKey(), parts.get(0).getValue()), new ToolRod(parts.get(1).getKey(), parts.get(1).getValue()));
            case "Hatchet" -> new Hatchet(new AxeHead(parts.get(0).getKey(), parts.get(0).getValue()), new ToolRod(parts.get(1).getKey(), parts.get(1).getValue()));
            case "Mattock" -> new Mattock(new AxeHead(parts.get(0).getKey(), parts.get(0).getValue()), new ShovelHead(parts.get(1).getKey(), parts.get(1).getValue()), new ToolRod(parts.get(2).getKey(), parts.get(2).getValue()));
            case "Hammer" -> new Hammer(new HammerHead(parts.get(0).getKey(), parts.get(0).getValue()), new LargePlate(parts.get(1).getKey(), parts.get(1).getValue()), new LargePlate(parts.get(2).getKey(), parts.get(2).getValue()), new ToughToolRod(parts.get(3).getKey(), parts.get(3).getValue()));
            case "Excavator" -> new Excavator(new BroadShovelHead(parts.get(0).getKey(), parts.get(0).getValue()), new LargePlate(parts.get(1).getKey(), parts.get(1).getValue()), new ToughBinding(parts.get(2).getKey(), parts.get(2).getValue()), new ToughToolRod(parts.get(3).getKey(), parts.get(3).getValue()));
            case "Lumber Axe" -> new LumberAxe(new BroadAxeHead(parts.get(0).getKey(), parts.get(0).getValue()), new LargePlate(parts.get(1).getKey(), parts.get(1).getValue()), new ToughBinding(parts.get(2).getKey(), parts.get(2).getValue()), new ToughToolRod(parts.get(3).getKey(), parts.get(3).getValue()));
            case "Scythe" -> new Scythe(new ScytheHead(parts.get(0).getKey(), parts.get(0).getValue()), new ToughBinding(parts.get(1).getKey(), parts.get(1).getValue()), new ToughToolRod(parts.get(2).getKey(), parts.get(2).getValue()), new ToughToolRod(parts.get(3).getKey(), parts.get(3).getValue()));
            default -> throw new IllegalArgumentException("tool not found: " + toolName);
        };
    }
}
