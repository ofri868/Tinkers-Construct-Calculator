package Logic.Materials.ExtraUtilities;

import Logic.Abilities.Whispering;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class DemonicMetal extends Material {
    public DemonicMetal() {
        super("Demonic Metal", 0.5, MiningLevel.IRON, 11.1, 0.25);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 80;
            case HANDLE -> 20;
            case EXTRA -> 100;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        if (type == PartType.HEAD) {
            abilities.add(new Whispering(1));
        }
    }
}
