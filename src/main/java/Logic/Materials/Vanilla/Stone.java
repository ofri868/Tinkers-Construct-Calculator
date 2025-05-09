package Logic.Materials.Vanilla;

import Logic.Abilities.Cheapskate;
import Logic.Abilities.Cheap;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Stone extends Material {
    public Stone(){
        super("Stone", 4, MiningLevel.IRON, 3, 0.5);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 120;
            case HANDLE -> -50;
            case EXTRA -> 20;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Cheapskate("grey"));
            case HANDLE, EXTRA -> abilities.add(new Cheap("grey"));
        }
    }
}
