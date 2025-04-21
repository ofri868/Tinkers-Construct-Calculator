package Tools.AdvancedTools;

import Parts.ToolPart;

public class Hammer extends AdvancedTool{
    public Hammer(String toolName, ToolPart head, ToolPart handle, ToolPart plate1, ToolPart plate2){
        super(toolName, head, handle, plate1, plate2);
    }

    @Override
    public void calculateDurability() {
        durability = (int)(Math.floor((double) (head.getMaterial().getDurability() + extra1.getMaterial().getDurability() + extra2.getMaterial().getDurability()) /3) * 9 * handle.getMaterial().getHandleModifier());
    }

    @Override
    public void calculateMiningSpeed() {
        miningSpeed = (head.getMaterial().getMiningSpeed() + extra1.getMaterial().getMiningSpeed() + extra2.getMaterial().getMiningSpeed()) / 7.5;
    }

    @Override
    public void calculateAttack() {
        attack = head.getMaterial().getBaseDamage() + 1.5;
    }
}
