package Logic.Materials.EnderIO;

import Logic.Abilities.Flammable;
import Logic.Abilities.Hellish;
import Logic.Materials.Material;
import Logic.Abilities.Splinters;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Soularium extends Material {
    public Soularium() {
        super("Soularium", 1, MiningLevel.STONE, 1, 0.5);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 1555;
            case HANDLE -> 1500;
            case EXTRA -> 1250;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Hellish(1));
            case HANDLE -> abilities.add(new Flammable(1));
            case EXTRA -> abilities.add(new Splinters(1));
        }
    }
}
