package Logic.Materials.TheTwilightForest;


import Logic.Abilities.Autosmelt;
import Logic.Abilities.Flammable;
import Logic.Materials.Material;
import Logic.Abilities.Superheat;
import Logic.Abilities.Twilit;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class FieryIngot extends Material {
    public FieryIngot() {
        super("Fiery Ingot", 7.2, MiningLevel.OBSIDIAN, 6.6, 0.7);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 720;
            case HANDLE -> 400;
            case EXTRA -> 200;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> {
                abilities.add(new Twilit(1));
                abilities.add(new Autosmelt(1));
                abilities.add(new Superheat(1));
                abilities.add(new Flammable(1));
            }
            case HANDLE, EXTRA -> {
                abilities.add(new Twilit(1));
                abilities.add(new Flammable(1));
            }
        }
    }
}
