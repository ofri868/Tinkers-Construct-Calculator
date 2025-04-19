package Tools.TwoPartTools;

import Parts.ToolPart;
import Tools.Tool;

public class Shovel extends Tool {
    public Shovel(String toolName, ToolPart head, ToolPart handle){
        super(toolName, head, handle);
    }

    @Override
    public void calculateDurability() {
        durability = (int)Math.round(head.getMaterial().getDurability()*handle.getMaterial().getHandleModifier());
    }

    @Override
    public void calculateMiningSpeed() { miningSpeed = head.getMaterial().getMiningSpeed(); }

    @Override
    public void calculateAttack() { attack = head.getMaterial().getBaseDamage()+1; }
}
