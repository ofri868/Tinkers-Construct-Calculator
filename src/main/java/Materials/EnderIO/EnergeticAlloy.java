package Materials.EnderIO;

import Abilities.Holy;
import Abilities.Petramor;
import Abilities.Unnatural;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class EnergeticAlloy extends Material {
    public EnergeticAlloy() {
        super("energetic alloy", 2.5, MiningLevel.OBSIDIAN, 5.6,2);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(690);
            case HANDLE -> setDurability(-800);
            case EXTRA -> setDurability(400);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Unnatural(1));
            case HANDLE -> abilities.add(new Holy(1));
            case EXTRA -> abilities.add(new Petramor(1));
        }
    }
}
