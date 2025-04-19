package Materials.ThermalExpansion;

import Abilities.WellEstablished;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class Copper extends Material {
    public Copper() {
        super("Copper", 5.3, MiningLevel.IRON, 3, 1.05);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(210);
            case HANDLE -> setDurability(30);
            case EXTRA -> setDurability(100);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new WellEstablished(1));
    }
}
