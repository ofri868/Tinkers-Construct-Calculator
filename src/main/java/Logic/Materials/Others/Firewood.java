package Logic.Materials.Others;

import Logic.Abilities.Autosmelt;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Firewood extends Material {
    public Firewood() {
        super("Firewood", 6, MiningLevel.STONE, 5.5, 1);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 550;
            case HANDLE -> -200;
            case EXTRA -> 150;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Autosmelt("red"));
    }
}
