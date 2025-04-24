package Logic.Materials.TinkersConstruct;

import Logic.Abilities.ColdBlooded;
import Logic.Abilities.Insatiable;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Manyullyn extends Material {
    public Manyullyn() {
        super("Manyullyn", 7.02, MiningLevel.COBALT, 8.72, 0.5);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 820;
            case HANDLE -> 250;
            case EXTRA -> 50;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Insatiable(1));
            case HANDLE, EXTRA -> abilities.add(new ColdBlooded(1));
        }
    }
}
