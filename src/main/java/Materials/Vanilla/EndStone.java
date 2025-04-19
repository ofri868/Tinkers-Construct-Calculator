package Materials.Vanilla;

import Abilities.Alien;
import Abilities.Enderference;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class EndStone extends Material {
    public EndStone() {
        super("End Stone", 3.23, MiningLevel.OBSIDIAN, 3.23, 0.85);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(420);
            case HANDLE -> setDurability(0);
            case EXTRA -> setDurability(42);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Alien(1));
            case HANDLE, EXTRA -> abilities.add(new Enderference(1));
        }
    }
}
