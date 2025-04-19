package Tools.BasicTools;

import Parts.ToolPart;

public class Pickaxe extends BasicTool{
    public Pickaxe(String toolName, ToolPart head, ToolPart extra, ToolPart handle){
        super(toolName, head, extra, handle);
    }

    @Override
    public void calculateDurability() {
        durability = (int)Math.round(head.getMaterial().getDurability()*handle.getMaterial().getHandleModifier());
    }

    @Override
    public void calculateMiningSpeed() {
        miningSpeed = head.getMaterial().getMiningSpeed();
    }

    @Override
    public void calculateAttack() {
        attack = head.getMaterial().getBaseDamage()+0.5;
    }
}
