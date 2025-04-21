package Logic.Tools.BasicTools;

import Logic.Parts.ToolPart;
import Logic.Tools.Tool;

public class Pickaxe extends Tool {
    private final ToolPart binding;

    public Pickaxe(String toolName, ToolPart head, ToolPart binding, ToolPart handle){
        super(toolName, head, handle);
        this.binding = binding;
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

    @Override
    public void calculateAbilities(){
        super.calculateAbilities();
        abilities.addAll(binding.getMaterial().getAbilities());
    }
}
