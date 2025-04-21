package Logic.Materials.TinkersConstruct;

import Logic.Abilities.Crumbling;
import Logic.Materials.Material;
import Logic.Abilities.Unnatural;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Knightslime extends Material {
    public Knightslime() {
        super("Knightslime", 5.8, MiningLevel.OBSIDIAN, 5.1, 0.5);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(850);
            case HANDLE -> setDurability(500);
            case EXTRA -> setDurability(125);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Crumbling(1));
            case HANDLE, EXTRA -> abilities.add(new Unnatural(1));
        }
    }
}
