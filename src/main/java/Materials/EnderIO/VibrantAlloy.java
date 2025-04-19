package Materials.EnderIO;

import Abilities.*;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class VibrantAlloy extends Material {
    public VibrantAlloy() {
        super("vibrant alloy", 3.5, MiningLevel.COBALT, 9, 0.5);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(220);
            case HANDLE -> setDurability(-50);
            case EXTRA -> setDurability(60);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        if (type == PartType.HANDLE) {
            abilities.add(new Vanishing(2));
        }
        else {
            abilities.add(new Direct(1));
        }
    }
}
