package Materials.TheTwilightForest;

import Abilities.Synergy;
import Abilities.Twilit;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class Steeleaf extends Material {
    public Steeleaf() {
        super("Steeleaf", 7, MiningLevel.DIAMOND, 6, 0.8);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(180);
            case HANDLE -> setDurability(100);
            case EXTRA -> setDurability(90);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Twilit(1));
        abilities.add(new Synergy(1));
    }
}
