package Logic.Materials.ExtraUtilities;

import Logic.Abilities.EvilAura;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class EvilInfusedIron extends Material {
    public EvilInfusedIron() {
        super("Evil Infused Iron", 13, MiningLevel.COBALT, 13, 1);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 666;
            case HANDLE -> 0;
            case EXTRA -> 66;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        if (type == PartType.HEAD) {
            abilities.add(new EvilAura(1));
        }
    }
}
