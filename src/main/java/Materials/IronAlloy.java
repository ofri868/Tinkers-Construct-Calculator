package Materials;

import Abilities.Cheapskate;
import Utils.MiningLevel;
import Utils.PartType;

public class IronAlloy extends Material{
    public IronAlloy(){
        super("Iron Alloy", 1.25, MiningLevel.IRON, 1, 0.5);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(50);
            case HANDLE, EXTRA -> setDurability(10);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Cheapskate(1));
    }
}
