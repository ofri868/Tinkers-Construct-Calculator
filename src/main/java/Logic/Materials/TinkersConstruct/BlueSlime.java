package Logic.Materials.TinkersConstruct;

import Logic.Materials.Material;
import Logic.Abilities.Slimey;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class BlueSlime extends Material {
    public BlueSlime(){
        super("Blue Slime", 4.03, MiningLevel.STONE, 1.8, 1.3);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 780;
            case HANDLE -> -50;
            case EXTRA -> 200;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Slimey(1));
    }
}
