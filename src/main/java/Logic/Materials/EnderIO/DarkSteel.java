package Logic.Materials.EnderIO;

import Logic.Abilities.Dense;
import Logic.Abilities.Enderference;
import Logic.Materials.Material;
import Logic.Abilities.Unnatural;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class DarkSteel extends Material {
    public DarkSteel() {
        super("Dark Steel", 7, MiningLevel.COBALT, 6, 0.9);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type){
            case HEAD -> 550;
            case HANDLE -> 150;
            case EXTRA -> 250;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Enderference("black"));
            case HANDLE -> abilities.add(new Unnatural("black"));
            case EXTRA -> abilities.add(new Dense("black"));
        }
    }
}
