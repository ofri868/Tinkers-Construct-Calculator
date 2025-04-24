package Logic.Tools.BasicTools;

import Logic.Parts.ToolParts.Handles.ToolRod;
import Logic.Parts.ToolParts.Heads.ShovelHead;
import Logic.Tools.Tool;

public class Shovel extends Tool {
    public Shovel(ShovelHead head, ToolRod handle){
        super("Shovel",  head, handle);
        calculateDurability();
        calculateMiningSpeed();
        calculateAttack();
        calculateAbilities();
    }

    @Override
    public void calculateDurability() {
        durability = (int)Math.round(head.getDurability()*handle.getHandleModifier());
    }

    @Override
    public void calculateMiningSpeed() { miningSpeed = head.getMiningSpeed(); }

    @Override
    public void calculateAttack() { attack = head.getAttack() + 1; }
}
