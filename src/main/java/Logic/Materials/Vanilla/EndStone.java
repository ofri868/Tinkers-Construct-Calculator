package Logic.Materials.Vanilla;

import Logic.Abilities.Alien;
import Logic.Abilities.Enderference;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class EndStone extends Material {
    public EndStone() {
        super("End Stone", 3.23, MiningLevel.OBSIDIAN, 3.23, 0.85);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 420;
            case HANDLE -> 0;
            case EXTRA -> 42;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Alien(1));
            case HANDLE, EXTRA -> abilities.add(new Enderference(1));
        }
    }
}
