package Logic.Materials.Vanilla;

import Logic.Abilities.Magnetic;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;


public class Iron extends Material {
    public Iron(){
        super("iron", 6, MiningLevel.DIAMOND, 2, 0.85);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 204;
            case HANDLE -> 60;
            case EXTRA -> 50;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Magnetic(2));
            case HANDLE, EXTRA -> abilities.add(new Magnetic(1));
        }
    }
}
