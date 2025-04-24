package Logic.Materials.EnderIO;

import Logic.Abilities.Direct;
import Logic.Materials.Material;
import Logic.Abilities.Vanishing;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class VibrantAlloy extends Material {
    public VibrantAlloy() {
        super("Vibrant Alloy", 3.5, MiningLevel.COBALT, 9, 0.5);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 220;
            case HANDLE -> -50;
            case EXTRA -> 60;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        if (type == PartType.HANDLE) {
            abilities.add(new Vanishing(2));
        }
        else {
            abilities.add(new Direct(1));
        }
    }
}
