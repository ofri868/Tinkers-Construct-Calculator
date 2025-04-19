package Materials.TinkersConstruct;

import Abilities.ColdBlooded;
import Abilities.Insatiable;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class Manyullyn extends Material {
    public Manyullyn() {
        super("Manyullyn", 7.02, MiningLevel.COBALT, 8.72, 0.5);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(820);
            case HANDLE -> setDurability(250);
            case EXTRA -> setDurability(50);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Insatiable(1));
            case HANDLE, EXTRA -> abilities.add(new ColdBlooded(1));
        }
    }
}
