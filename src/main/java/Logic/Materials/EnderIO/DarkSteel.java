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
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(550);
            case HANDLE -> setDurability(150);
            case EXTRA -> setDurability(250);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Enderference(1));
            case HANDLE -> abilities.add(new Unnatural(1));
            case EXTRA -> abilities.add(new Dense(1));
        }
    }
}
