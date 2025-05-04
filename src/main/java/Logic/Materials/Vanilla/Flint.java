package Logic.Materials.Vanilla;

import Logic.Abilities.Crude;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Flint extends Material {
    public Flint() {
        super("Flint", 5, MiningLevel.IRON, 2.9, 0.6);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 150;
            case HANDLE -> -60;
            case EXTRA -> 40;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Crude(2, "black"));
            case HANDLE, EXTRA -> abilities.add(new Crude(1, "black"));
        }
    }
}
