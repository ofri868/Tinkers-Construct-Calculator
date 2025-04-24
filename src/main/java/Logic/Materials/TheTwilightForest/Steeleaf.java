package Logic.Materials.TheTwilightForest;

import Logic.Materials.Material;
import Logic.Abilities.Synergy;
import Logic.Abilities.Twilit;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Steeleaf extends Material {
    public Steeleaf() {
        super("Steeleaf", 7, MiningLevel.DIAMOND, 6, 0.8);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 180;
            case HANDLE -> 100;
            case EXTRA -> 90;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Twilit(1));
        abilities.add(new Synergy(1));
    }
}
