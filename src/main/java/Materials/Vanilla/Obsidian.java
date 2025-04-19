package Materials.Vanilla;

import Abilities.Duritae;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class Obsidian extends Material {
    public Obsidian() {
        super("Obsidian", 7.07, MiningLevel.COBALT, 4.2, 0.9);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(139);
            case HANDLE -> setDurability(-100);
            case EXTRA -> setDurability(90);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Duritae(1));
    }
}
