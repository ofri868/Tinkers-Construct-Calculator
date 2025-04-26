package Logic.Materials.Others;

import Logic.Abilities.ThermalInversion;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Constantan extends Material {
    public Constantan() {
        super("Constantan", 4.7, MiningLevel.DIAMOND, 4, 0.8);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 25;
            case HANDLE, EXTRA -> 60;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new ThermalInversion(1));
    }
}
