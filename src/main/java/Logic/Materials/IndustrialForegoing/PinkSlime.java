package Logic.Materials.IndustrialForegoing;

import Logic.Abilities.Slimey;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class PinkSlime extends Material {
    public PinkSlime(){
        super("Pink Slime", 3, MiningLevel.STONE, 1, 2.5);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD, HANDLE -> 2000;
            case EXTRA -> 200;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Slimey(1));
    }
}
