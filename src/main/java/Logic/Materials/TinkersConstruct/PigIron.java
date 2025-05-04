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
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 380;
            case HANDLE -> 0;
            case EXTRA -> 170;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> {
                abilities.add(new Baconlicious("pink"));
                abilities.add(new Tasty("pink"));
            }
            case HANDLE, EXTRA -> abilities.add(new Tasty("pink"));
        }
    }
}
