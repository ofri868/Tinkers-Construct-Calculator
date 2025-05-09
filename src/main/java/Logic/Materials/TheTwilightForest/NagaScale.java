package Logic.Materials.TheTwilightForest;

import Logic.Materials.Material;
import Logic.Abilities.Precipitate;
import Logic.Abilities.Twilit;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class NagaScale extends Material {
    public NagaScale() {
        super("Naga Scale", 8.9, MiningLevel.IRON, 4.3, 1);
    }

    @Override
    public int getDurability(PartType type) {
        return 460;
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Twilit("green"));
        abilities.add(new Precipitate("green"));
    }
}
