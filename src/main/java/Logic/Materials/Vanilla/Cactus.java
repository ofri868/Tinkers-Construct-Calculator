package Logic.Materials.Vanilla;

import Logic.Materials.Material;
import Logic.Abilities.Prickly;
import Logic.Abilities.Spiky;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

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
