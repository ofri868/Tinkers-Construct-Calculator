package Logic.Materials.Vanilla;

import Logic.Materials.Material;
import Logic.Abilities.Slimey;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Slime extends Material {
    public Slime(){
        super("Slime", 4.24, MiningLevel.STONE, 1.8, 0.7);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 1000;
            case HANDLE -> 0;
            case EXTRA -> 350;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Slimey("#81fe89"));
    }
}
