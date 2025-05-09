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
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 210;
            case HANDLE -> 20;
            case EXTRA -> 50;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Prickly("green"));
            case HANDLE, EXTRA -> abilities.add(new Spiky("green"));
        }
    }
}
