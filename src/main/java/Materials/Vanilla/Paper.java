package Materials.Vanilla;

import Abilities.Writeable;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class Paper extends Material {
    public Paper() {
        super("Paper", 0.51, MiningLevel.STONE, 0.05, 0.1);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(12);
            case HANDLE -> setDurability(5);
            case EXTRA -> setDurability(15);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Writeable(1));
    }
}
