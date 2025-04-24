package Logic.Tools.AdvancedTools;

import Logic.Parts.ToolParts.Extras.LargePlate;
import Logic.Parts.ToolParts.Handles.ToughToolRod;
import Logic.Parts.ToolParts.Heads.HammerHead;

public class Hammer extends AdvancedTool{
    public Hammer(HammerHead head, LargePlate plate1, LargePlate plate2, ToughToolRod handle){
        super("Hammer", head, handle, plate1, plate2);
        calculateDurability();
        calculateMiningSpeed();
        calculateAttack();
        calculateAbilities();
    }

    @Override
    public void calculateDurability() {
        durability = (int)(Math.floor((double)(head.getDurability() + extra1.getDurability() + extra2.getDurability()) /3) * 9 * handle.getHandleModifier());
    }

    @Override
    public void calculateMiningSpeed() {
        miningSpeed = (head.getMiningSpeed() + extra1.getMaterial().getMiningSpeed() + extra2.getMaterial().getMiningSpeed()) / 7.5;
        miningSpeed = Math.round(miningSpeed * 100.0)/100.0;
    }

    @Override
    public void calculateAttack() {
        attack = head.getMaterial().getBaseDamage() + 1.5;
    }
}
