package Logic.Materials.Vanilla;

import Logic.Abilities.Aridiculous;
import Logic.Abilities.Hellish;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Netherrack extends Material {
    public Netherrack() {
        super("Netherrack", 4.5, MiningLevel.IRON, 3, 0.85);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 270;
            case HANDLE -> -150;
            case EXTRA -> 75;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> {
                abilities.add(new Aridiculous(1));
                abilities.add(new Hellish(1));
            }
            case HANDLE, EXTRA -> abilities.add(new Hellish(1));
        }
    }
}
