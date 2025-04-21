package Logic.Materials.ThermalExpansion;

import Logic.Materials.Material;
import Logic.Abilities.WellEstablished;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

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
