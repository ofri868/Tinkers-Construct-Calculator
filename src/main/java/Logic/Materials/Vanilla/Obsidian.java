package Logic.Materials.Vanilla;

import Logic.Abilities.Duritae;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Obsidian extends Material {
    public Obsidian() {
        super("Obsidian", 7.07, MiningLevel.COBALT, 4.2, 0.9);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 139;
            case HANDLE -> -100;
            case EXTRA -> 90;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Duritae(1));
    }
}
