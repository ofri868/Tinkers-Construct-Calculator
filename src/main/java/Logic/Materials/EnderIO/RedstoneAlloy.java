package Logic.Materials.EnderIO;

import Logic.Abilities.Crude;
import Logic.Materials.Material;
import Logic.Abilities.Shocking;
import Logic.Abilities.Writeable;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class RedstoneAlloy extends Material {
    public RedstoneAlloy() {
        super("Redstone Alloy", 2.5, MiningLevel.STONE, 1.5, 1);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 120;
            case HANDLE -> -5;
            case EXTRA -> 150;
        };
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
