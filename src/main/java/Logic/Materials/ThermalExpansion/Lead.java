package Logic.Materials.ThermalExpansion;

import Logic.Abilities.Heavy;
import Logic.Abilities.Poisonous;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Lead extends Material {
    public Lead() {
        super("Lead", 5.25, MiningLevel.IRON, 3.5, 0.7);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 434;
            case HANDLE -> -50;
            case EXTRA -> 100;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Poisonous("#553c62"));
        abilities.add(new Heavy("#553c62"));
    }
}
