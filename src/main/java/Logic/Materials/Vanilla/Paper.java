package Logic.Materials.Vanilla;

import Logic.Materials.Material;
import Logic.Abilities.Writeable;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Paper extends Material {
    public Paper() {
        super("Paper", 0.51, MiningLevel.STONE, 0.05, 0.1);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 12;
            case HANDLE -> 5;
            case EXTRA -> 15;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Writeable(1, "white"));
    }
}
