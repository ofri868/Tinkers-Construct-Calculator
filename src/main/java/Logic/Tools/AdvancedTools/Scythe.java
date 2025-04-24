package Logic.Tools.AdvancedTools;

import Logic.Parts.ToolParts.Extras.ToughBinding;
import Logic.Parts.ToolParts.Handles.ToughToolRod;
import Logic.Parts.ToolParts.Heads.ScytheHead;

public class Scythe extends AdvancedTool{
    public Scythe(ScytheHead head, ToughBinding binding, ToughToolRod handle1, ToughToolRod handle2){
        super("Scythe", head, handle1, binding, handle2);
        calculateDurability();
        calculateMiningSpeed();
        calculateAttack();
        calculateAbilities();
    }

    @Override
    public void calculateDurability() {

    }

    @Override
    public void calculateMiningSpeed() {

    }

    @Override
    public void calculateAttack() {
        attack = head.getAttack() +1.5;
    }
}
