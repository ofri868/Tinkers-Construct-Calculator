package Logic.Materials.TinkersConstruct;

import Logic.Abilities.Baconlicious;
import Logic.Materials.Material;
import Logic.Abilities.Tasty;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class PigIron extends Material {
    public PigIron() {
        super("Pig Iron", 6.2, MiningLevel.DIAMOND, 4.5, 1.2);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(380);
            case HANDLE -> setDurability(0);
            case EXTRA -> setDurability(170);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> {
                abilities.add(new Baconlicious(1));
                abilities.add(new Tasty(1));
            }
            case HANDLE, EXTRA -> abilities.add(new Tasty(1));
        }
    }
}
