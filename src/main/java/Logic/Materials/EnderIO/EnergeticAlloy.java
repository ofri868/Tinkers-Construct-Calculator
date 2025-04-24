package Logic.Materials.EnderIO;

import Logic.Abilities.Holy;
import Logic.Materials.Material;
import Logic.Abilities.Petramor;
import Logic.Abilities.Unnatural;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class EnergeticAlloy extends Material {
    public EnergeticAlloy() {
        super("Energetic Alloy", 2.5, MiningLevel.OBSIDIAN, 5.6,2);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 690;
            case HANDLE -> -800;
            case EXTRA -> 400;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Unnatural(1));
            case HANDLE -> abilities.add(new Holy(1));
            case EXTRA -> abilities.add(new Petramor(1));
        }
    }
}
