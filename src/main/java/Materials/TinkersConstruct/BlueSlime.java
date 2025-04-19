package Materials.TinkersConstruct;

import Abilities.Slimey;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class BlueSlime extends Material {
    public BlueSlime(){
        super("Blue Slime", 4.03, MiningLevel.STONE, 1.8, 1.3);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(780);
            case HANDLE -> setDurability(-50);
            case EXTRA -> setDurability(200);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Slimey(1));
    }
}
