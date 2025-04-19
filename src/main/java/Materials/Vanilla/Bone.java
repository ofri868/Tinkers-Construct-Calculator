package Materials.Vanilla;

import Abilities.Crude;
import Abilities.Fractured;
import Abilities.Lightweight;
import Abilities.Splintering;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class Bone extends Material {
    public Bone() {
        super("Bone", 5.09, MiningLevel.IRON, 2.5, 1.1);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(200);
            case HANDLE -> setDurability(50);
            case EXTRA -> setDurability(65);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Splintering(1));
            case HANDLE, EXTRA -> abilities.add(new Fractured(1));
        }
    }
}
