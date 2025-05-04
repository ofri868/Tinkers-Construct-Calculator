package Logic.Materials.Others;

import Logic.Abilities.Cheapskate;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class IronAlloy extends Material {
    public IronAlloy(){
        super("Iron Alloy", 1.25, MiningLevel.IRON, 1, 0.5);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 50;
            case HANDLE, EXTRA -> 10;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Cheapskate("grey"));
    }
}
