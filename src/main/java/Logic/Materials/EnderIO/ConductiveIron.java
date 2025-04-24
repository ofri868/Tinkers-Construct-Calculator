package Logic.Materials.EnderIO;

import Logic.Abilities.Crude;
import Logic.Abilities.Lightweight;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class ConductiveIron extends Material {
    public ConductiveIron() {
        super("Conductive Iron", 6.75, MiningLevel.DIAMOND, 1.25, 1.25);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 106;
            case HANDLE -> 100;
            case EXTRA -> 250;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Crude(2));
            case HANDLE, EXTRA -> abilities.add(new Lightweight(1));
        }
    }
}
