package Logic.Materials.Vanilla;

import Logic.Abilities.Fractured;
import Logic.Materials.Material;
import Logic.Abilities.Splintering;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Bone extends Material {
    public Bone() {
        super("Bone", 5.09, MiningLevel.IRON, 2.5, 1.1);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 200;
            case HANDLE -> 50;
            case EXTRA -> 65;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Splintering(1));
            case HANDLE, EXTRA -> abilities.add(new Fractured(1));
        }
    }
}
