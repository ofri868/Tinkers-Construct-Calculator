package Logic.Materials.TinkersConstruct;

import Logic.Abilities.Flammable;
import Logic.Materials.Material;
import Logic.Abilities.Superheat;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class MagmaSlime extends Material {
    public MagmaSlime(){
        super("Magma Slime", 2.1, MiningLevel.STONE, 7, 0.85);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 600;
            case HANDLE -> -200;
            case EXTRA -> 150;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Superheat("orange"));
            case HANDLE, EXTRA -> abilities.add(new Flammable("orange"));
        }
    }
}
