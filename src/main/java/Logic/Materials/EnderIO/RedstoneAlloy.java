package Logic.Materials.EnderIO;

import Logic.Abilities.Crude;
import Logic.Materials.Material;
import Logic.Abilities.Shocking;
import Logic.Abilities.Writeable;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class RedstoneAlloy extends Material {
    public RedstoneAlloy() {
        super("redstone alloy", 2.5, MiningLevel.STONE, 1.5, 1);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(120);
            case HANDLE -> setDurability(-5);
            case EXTRA -> setDurability(150);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Shocking(1));
            case HANDLE -> abilities.add(new Writeable(1));
            case EXTRA -> abilities.add(new Crude(1));
        }
    }
}
