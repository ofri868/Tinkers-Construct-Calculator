package Logic.Tools.BasicTools;

import Logic.Parts.ToolParts.Extras.ToolBinding;
import Logic.Parts.ToolParts.Handles.ToolRod;
import Logic.Parts.ToolParts.Heads.PickaxeHead;
import Logic.Parts.ToolParts.ToolPart;
import Logic.Tools.Tool;

public class Pickaxe extends Tool {
    private final ToolPart binding;

    public Pickaxe(PickaxeHead head, ToolBinding binding, ToolRod handle){
        super("Pickaxe", head, handle);
        this.binding = binding;
        calculateDurability();
        calculateMiningSpeed();
        calculateAttack();
        calculateAbilities();
    }

    @Override
    public void calculateDurability() {
        durability = (int)Math.round(head.getDurability() * handle.getHandleModifier());
    }

    @Override
    public void calculateMiningSpeed() {
        miningSpeed = head.getMiningSpeed();
    }

    @Override
    public void calculateAttack() {
        attack = head.getAttack()+0.5;
    }

    @Override
    public void calculateAbilities(){
        super.calculateAbilities();
        abilities.addAll(binding.getMaterial().getAbilities());
    }

    @Override
    public String getPartsString(){
        return super.getPartsString() + "\n" + binding;
    }
}
