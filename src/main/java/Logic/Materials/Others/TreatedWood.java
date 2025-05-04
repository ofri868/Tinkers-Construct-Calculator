package Logic.Materials.Others;

import Logic.Abilities.Ecological;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class TreatedWood extends Material {
    public TreatedWood() {
        super("Treated Wood", 2, MiningLevel.STONE, 2, 1);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 25;
            case HANDLE -> -35;
            case EXTRA -> 20;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Ecological("red"));
    }
}
