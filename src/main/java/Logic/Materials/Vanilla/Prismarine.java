package Logic.Materials.Vanilla;

import Logic.Abilities.Aquadynamic;
import Logic.Abilities.Jagged;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Prismarine extends Material {
    public Prismarine() {
        super("Prismarine", 5.5, MiningLevel.IRON, 6.2, 0.6);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 430;
            case HANDLE -> -150;
            case EXTRA -> 100;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> {
                abilities.add(new Aquadynamic("#00f8ce"));
                abilities.add(new Jagged("#00f8ce"));
            }
            case HANDLE, EXTRA -> abilities.add(new Aquadynamic("#00f8ce"));
        }
    }
}
