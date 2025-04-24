package Logic.Tools.AdvancedTools;

import Logic.Parts.ToolPart;

public class Excavator extends AdvancedTool{
    public Excavator(String toolName, ToolPart head, ToolPart plate, ToolPart binding, ToolPart handle) {
        super(toolName, head, handle, plate, binding);
    }

    @Override
    public void calculateDurability() {
        durability = (int)((head.getMaterial().getDurability() + extra1.getMaterial().getDurability()) * (handle.getMaterial().getHandleModifier() + extra2.getMaterial().getHandleModifier()) * 1.5);
    }

    @Override
    public void calculateMiningSpeed() {
        miningSpeed = (head.getMaterial().getMiningSpeed() + extra1.getMaterial().getMiningSpeed())/5;
    }

    @Override
    public void calculateAttack() {
        attack = head.getMaterial().getBaseDamage() + 1;
    }
}
