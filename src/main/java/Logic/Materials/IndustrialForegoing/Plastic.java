package Logic.Materials.IndustrialForegoing;

import Logic.Abilities.Stonebound;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Plastic extends Material {
    public Plastic() {
        super("Plastic", 6, MiningLevel.STONE, -1, 0.1);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD, HANDLE -> 1500;
            case EXTRA -> 150;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Stonebound("grey"));
    }
}
