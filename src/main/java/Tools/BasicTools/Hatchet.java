package Tools.BasicTools;

import Parts.ToolPart;
import Tools.Tool;

public class Hatchet extends Tool {
    public Hatchet(String toolName, ToolPart head, ToolPart handle){
        super(toolName, head, handle);
    }

    @Override
    public void calculateDurability() {
        durability = (int)Math.round(head.getMaterial().getDurability()*handle.getMaterial().getHandleModifier());
    }

    @Override
    public void calculateMiningSpeed() { miningSpeed = head.getMaterial().getMiningSpeed(); }

    @Override
    public void calculateAttack() { attack = head.getMaterial().getBaseDamage(); }
}
