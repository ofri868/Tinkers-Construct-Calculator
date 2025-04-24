package Logic.Tools.BasicTools;

import Logic.Parts.ToolParts.Handles.ToolRod;
import Logic.Parts.ToolParts.Heads.AxeHead;
import Logic.Tools.Tool;

public class Hatchet extends Tool {
    public Hatchet(AxeHead head, ToolRod handle){
        super("Hatchet", head, handle);
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
    public void calculateAttack() { attack = head.getAttack(); }
}
