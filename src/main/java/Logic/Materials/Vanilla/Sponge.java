package Logic.Materials.Vanilla;

import Logic.Materials.Material;
import Logic.Abilities.Squeaky;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Sponge extends Material {
    public Sponge() {
        super("Sponge", 3.02, MiningLevel.STONE, 0, 1.2);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 1050;
            case HANDLE, EXTRA -> 250;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Squeaky("#daff54"));
    }
}
