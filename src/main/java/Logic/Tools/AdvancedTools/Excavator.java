package Logic.Tools.AdvancedTools;

import Logic.Parts.ToolParts.Extras.LargePlate;
import Logic.Parts.ToolParts.Extras.ToughBinding;
import Logic.Parts.ToolParts.Handles.ToughToolRod;
import Logic.Parts.ToolParts.Heads.BroadShovelHead;

public class Excavator extends AdvancedTool{
    public Excavator(BroadShovelHead head, LargePlate plate, ToughBinding binding, ToughToolRod handle) {
        super("Excavator", head, handle, plate, binding);
        calculateDurability();
        calculateMiningSpeed();
        calculateAttack();
        calculateAbilities();
    }

    @Override
    public void calculateDurability() {
        durability = (int)((head.getDurability() + extra1.getDurability()) * (handle.getHandleModifier() + extra2.getMaterial().getHandleModifier()) * 1.5);
    }

    @Override
    public void calculateMiningSpeed() {
        miningSpeed = (head.getMiningSpeed() + extra1.getMaterial().getMiningSpeed())/5;
        miningSpeed = Math.round(miningSpeed * 100.0)/100.0;
    }

    @Override
    public void calculateAttack() {
        attack = head.getAttack() + 1;
    }
}
