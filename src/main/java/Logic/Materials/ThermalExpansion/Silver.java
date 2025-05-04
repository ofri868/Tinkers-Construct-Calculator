package Logic.Materials.ThermalExpansion;

import Logic.Abilities.Holy;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Silver extends Material {
    public Silver() {
        super("Silver", 5, MiningLevel.IRON, 5, 0.95);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 250;
            case HANDLE -> 50;
            case EXTRA -> 150;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Holy("#b6b6b6"));
    }
}
