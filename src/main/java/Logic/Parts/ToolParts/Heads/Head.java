package Logic.Parts.ToolParts.Heads;

import Logic.Materials.Material;
import Logic.Parts.ToolParts.ToolPart;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public abstract class Head extends ToolPart {
    protected final double miningSpeed;
    protected final double attack;
    protected final MiningLevel miningLevel;

    public Head(String name, PartType partType, Material material) {
        super(name, partType, material);
        miningSpeed = material.getMiningSpeed();
        attack = material.getBaseDamage();
        miningLevel = material.getMiningLevel();
    }

    public double getMiningSpeed() {
        return miningSpeed;
    }
    public double getAttack(){
        return attack;
    }
    public MiningLevel getMiningLevel() {
        return miningLevel;
    }
}
