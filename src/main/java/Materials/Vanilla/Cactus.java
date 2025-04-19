package Materials.Vanilla;

import Abilities.Crude;
import Abilities.Lightweight;
import Abilities.Prickly;
import Abilities.Spiky;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class Cactus extends Material {
    public Cactus() {
        super("Cactus", 4, MiningLevel.IRON, 3.4, 0.85);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(210);
            case HANDLE -> setDurability(20);
            case EXTRA -> setDurability(50);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Prickly(1));
            case HANDLE, EXTRA -> abilities.add(new Spiky(1));
        }
    }
}
