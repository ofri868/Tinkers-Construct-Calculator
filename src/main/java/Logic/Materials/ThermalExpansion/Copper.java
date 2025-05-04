package Logic.Materials.ThermalExpansion;

import Logic.Materials.Material;
import Logic.Abilities.WellEstablished;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Copper extends Material {
    public Copper() {
        super("Copper", 5.3, MiningLevel.IRON, 3, 1.05);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 210;
            case HANDLE -> 30;
            case EXTRA -> 100;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new WellEstablished("#CD7F32"));
    }
}
