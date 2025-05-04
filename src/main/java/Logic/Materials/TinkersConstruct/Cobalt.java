package Logic.Materials.TinkersConstruct;

import Logic.Abilities.Lightweight;
import Logic.Materials.Material;
import Logic.Abilities.Momentum;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Cobalt extends Material {
    public Cobalt() {
        super("Cobalt", 12, MiningLevel.COBALT, 4.1, 0.9);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 780;
            case HANDLE -> 100;
            case EXTRA -> 300;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Momentum("blue"));
            case HANDLE, EXTRA -> abilities.add(new Lightweight("blue"));
        }
    }
}
