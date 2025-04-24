package Logic.Materials.TheTwilightForest;

import Logic.Materials.Material;
import Logic.Abilities.Stalwart;
import Logic.Abilities.Twilit;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class KnightmetalIngot extends Material {
    public KnightmetalIngot() {
        super("Knightmetal Ingot", 7, MiningLevel.COBALT, 6, 1.25);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 900;
            case HANDLE -> 100;
            case EXTRA -> 400;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Twilit(1));
        abilities.add(new Stalwart(1));
    }
}
