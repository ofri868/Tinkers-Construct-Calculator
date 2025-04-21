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
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(600);
            case HANDLE -> setDurability(-200);
            case EXTRA -> setDurability(150);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Superheat(1));
            case HANDLE, EXTRA -> abilities.add(new Flammable(1));
        }
    }
}
