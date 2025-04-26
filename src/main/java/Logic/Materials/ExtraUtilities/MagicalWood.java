package Logic.Materials.ExtraUtilities;

import Logic.Abilities.MagicallyBrittle;
import Logic.Abilities.MagicallyModifiable;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class MagicalWood extends Material {
    public MagicalWood() {
        super("Magical Wood", 2, MiningLevel.STONE, 2, 1);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 35;
            case HANDLE -> 25;
            case EXTRA -> 15;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new MagicallyModifiable(1));
        abilities.add(new MagicallyBrittle(1));
    }
}
