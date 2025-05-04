package Logic.Materials.ThermalExpansion;

import Logic.Abilities.Dense;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Bronze extends Material {
    public Bronze() {
        super("Bronze", 6.8, MiningLevel.DIAMOND, 3.5, 1.1);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 430;
            case HANDLE -> 70;
            case EXTRA -> 80;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Dense("#CD7F32"));
    }
}
