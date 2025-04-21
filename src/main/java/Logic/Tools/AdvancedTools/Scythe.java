package Logic.Tools.AdvancedTools;

import Logic.Parts.ToolPart;

public class Scythe extends AdvancedTool{
    public Scythe(String toolName, ToolPart head, ToolPart binding, ToolPart handle1, ToolPart handle2){
        super(toolName, head, handle1, binding, handle2);
    }

    @Override
    public void calculateDurability() {

    }

    @Override
    public void calculateMiningSpeed() {

    }

    @Override
    public void calculateAttack() {
        attack = head.getMaterial().getBaseDamage() +1.5;
    }
}
