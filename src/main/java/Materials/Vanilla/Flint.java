package Materials.Vanilla;

import Abilities.Crude;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class Flint extends Material {
    public Flint() {
        super("Flint", 5, MiningLevel.IRON, 2.9, 0.6);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(150);
            case HANDLE -> setDurability(-60);
            case EXTRA -> setDurability(40);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Crude(2));
            case HANDLE, EXTRA -> abilities.add(new Crude(1));
        }
    }
}
