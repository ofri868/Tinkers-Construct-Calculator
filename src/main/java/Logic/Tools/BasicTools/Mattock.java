package Logic.Tools.BasicTools;

import Logic.Parts.ToolParts.Handles.ToolRod;
import Logic.Parts.ToolParts.Heads.AxeHead;
import Logic.Parts.ToolParts.Heads.ShovelHead;
import Logic.Tools.Tool;

public class Mattock extends Tool {
    private final ShovelHead shovelHead;

    public Mattock(AxeHead head, ShovelHead shovelHead, ToolRod handle) {
        super("Mattock", head, handle);
        this.shovelHead = shovelHead;
        calculateDurability();
        calculateMiningSpeed();
        calculateAttack();
        calculateAbilities();
    }

    @Override
    public void calculateDurability() {
        durability = (int)((head.getDurability() + shovelHead.getDurability()) * 0.75 * handle.getHandleModifier());
    }

    @Override
    public void calculateMiningSpeed() {
        miningSpeed = head.getMiningSpeed();
    }

    @Override
    public void calculateAttack() {
        attack = head.getAttack() + 2;
    }

    @Override
    public String getPartsString(){
        return head + "\n" + shovelHead + "\n" + handle;
    }
}
