package Logic.Materials.TinkersConstruct;

import Logic.Materials.Material;
import Logic.Abilities.Petramor;
import Logic.Abilities.Stonebound;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Ardite extends Material {
    public Ardite() {
        super("Ardite", 3.5, MiningLevel.COBALT, 3.6, 1.4);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 990;
            case HANDLE -> -200;
            case EXTRA -> 450;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Stonebound(1));
            case HANDLE, EXTRA -> abilities.add(new Petramor(1));
        }
    }
}
