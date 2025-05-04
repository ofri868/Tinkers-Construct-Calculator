package Logic.Materials.ThermalExpansion;

import Logic.Abilities.Shocking;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Electrum extends Material {
    public Electrum() {
        super("Electrum", 12, MiningLevel.IRON, 3, 1.1);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 50;
            case HANDLE -> -25;
            case EXTRA -> 250;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Shocking("yellow"));
    }
}
