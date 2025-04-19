package Materials.TinkersConstruct;

import Abilities.Lightweight;
import Abilities.Momentum;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class Cobalt extends Material {
    public Cobalt() {
        super("Cobalt", 12, MiningLevel.COBALT, 4.1, 0.9);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(780);
            case HANDLE -> setDurability(100);
            case EXTRA -> setDurability(300);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Momentum(1));
            case HANDLE, EXTRA -> abilities.add(new Lightweight(1));
        }
    }
}
