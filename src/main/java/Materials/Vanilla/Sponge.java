package Materials.Vanilla;

import Abilities.Squeaky;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class Sponge extends Material {
    public Sponge() {
        super("Sponge", 3.02, MiningLevel.STONE, 0, 1.2);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(1050);
            case HANDLE, EXTRA -> setDurability(250);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Squeaky(1));
    }
}
