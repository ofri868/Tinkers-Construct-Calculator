package Logic.Tools.BasicTools;

import Logic.Parts.ToolPart;
import Logic.Tools.Tool;

public class Mattock extends Tool {
    private final ToolPart shovelHead;

    public Mattock(String toolName, ToolPart head, ToolPart shovelHead, ToolPart handle) {
        super(toolName, head, handle);
        this.shovelHead = shovelHead;
        calculateAbilities();
    }

    @Override
    public void calculateDurability() {
        durability = (int)((head.getMaterial().getDurability() + shovelHead.getMaterial().getDurability()) * 0.75 * handle.getMaterial().getHandleModifier());
    }

    @Override
    public void calculateMiningSpeed() {
        miningSpeed = handle.getMaterial().getMiningSpeed();
    }

    @Override
    public void calculateAttack() {
        attack = head.getMaterial().getBaseDamage() + 2;
    }
}
