package Materials.TheTwilightForest;

import Abilities.*;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class FieryIngot extends Material {
    public FieryIngot() {
        super("Fiery Ingot", 7.2, MiningLevel.OBSIDIAN, 6.6, 0.7);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(720);
            case HANDLE -> setDurability(400);
            case EXTRA -> setDurability(200);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> {
                abilities.add(new Twilit(1));
                abilities.add(new Autosmelt(1));
                abilities.add(new Superheat(1));
                abilities.add(new Flammable(1));
            }
            case HANDLE, EXTRA -> {
                abilities.add(new Twilit(1));
                abilities.add(new Flammable(1));
            }
        }
    }
}
