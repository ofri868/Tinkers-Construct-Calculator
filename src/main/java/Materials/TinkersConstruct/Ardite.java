package Materials.TinkersConstruct;

import Abilities.Petramor;
import Abilities.Stonebound;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class Ardite extends Material {
    public Ardite() {
        super("Ardite", 3.5, MiningLevel.COBALT, 3.6, 1.4);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(990);
            case HANDLE -> setDurability(-200);
            case EXTRA -> setDurability(450);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Stonebound(1));
            case HANDLE, EXTRA -> abilities.add(new Petramor(1));
        }
    }
}
