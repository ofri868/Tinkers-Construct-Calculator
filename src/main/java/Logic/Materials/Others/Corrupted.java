package Logic.Materials.Others;

import Logic.Abilities.Vile;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Corrupted extends Material {
    public Corrupted() {
        super("Corrupted", 6, MiningLevel.DIAMOND, 4, 0.85);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 204;
            case HANDLE -> 60;
            case EXTRA -> 50;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        if (type == PartType.HEAD) {
            abilities.add(new Vile(1));
        }
    }
}
