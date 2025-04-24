package Logic.Materials.EnderIO;

import Logic.Abilities.Lightweight;
import Logic.Materials.Material;
import Logic.Abilities.Shocking;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class ElectricalSteel extends Material {
    public ElectricalSteel() {
        super("Electrical Steel", 6.5, MiningLevel.DIAMOND, 2.25,0.75);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 306;
            case HANDLE -> 80;
            case EXTRA -> 75;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Shocking(1));
            case HANDLE, EXTRA -> abilities.add(new Lightweight(1));
        }
    }
}
