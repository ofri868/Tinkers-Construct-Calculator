package Materials.EnderIO;

import Abilities.*;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class EndSteel extends Material {
    public EndSteel() {
        super("End Steel", 8.25, MiningLevel.COBALT, 5, 0.9);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(400);
            case HANDLE, EXTRA -> setDurability(50);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> {
                abilities.add(new Enderference(1));
                abilities.add(new Alien(1));
            }
            case HANDLE, EXTRA -> abilities.add(new Unnatural(1));
        }
    }
}
