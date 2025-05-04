package Logic.Materials.ExtraUtilities;

import Logic.Abilities.ExperienceBoost;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class EnchantedMetal extends Material {
    public EnchantedMetal() {
        super("Enchanted Metal", 7, MiningLevel.IRON, 3.5, 1.1);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 350;
            case HANDLE -> 20;
            case EXTRA -> 80;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new ExperienceBoost("#7ff80d"));
    }
}
