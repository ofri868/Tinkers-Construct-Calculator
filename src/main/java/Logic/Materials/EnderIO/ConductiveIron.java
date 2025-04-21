package Logic.Materials.EnderIO;

import Logic.Abilities.Crude;
import Logic.Abilities.Lightweight;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class ConductiveIron extends Material {
    public ConductiveIron() {
        super("conductive iron", 6.75, MiningLevel.DIAMOND, 1.25, 1.25);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(106);
            case HANDLE -> setDurability(100);
            case EXTRA -> setDurability(250);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Crude(2));
            case HANDLE, EXTRA -> abilities.add(new Lightweight(1));
        }
    }
}
