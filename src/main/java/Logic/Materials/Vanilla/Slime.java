package Logic.Materials.Vanilla;

import Logic.Materials.Material;
import Logic.Abilities.Slimey;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Slime extends Material {
    public Slime(){
        super("Slime", 4.24, MiningLevel.STONE, 1.8, 0.7);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(1000);
            case HANDLE -> setDurability(0);
            case EXTRA -> setDurability(350);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Slimey(1));
    }
}
