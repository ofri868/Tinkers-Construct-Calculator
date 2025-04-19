package Tools.BasicTools;

import Parts.Part;

public class Pickaxe extends BasicTool{
    public Pickaxe(String toolName, Part head, Part extra, Part handle){
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
