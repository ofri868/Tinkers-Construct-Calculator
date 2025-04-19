package Materials.EnderIO;

import Abilities.Crude;
import Abilities.Lightweight;
import Abilities.Shocking;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class ElectricalSteel extends Material {
    public ElectricalSteel() {
        super("electrical steel", 6.5, MiningLevel.DIAMOND, 2.25,0.75);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(306);
            case HANDLE -> setDurability(80);
            case EXTRA -> setDurability(75);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Shocking(1));
            case HANDLE, EXTRA -> abilities.add(new Lightweight(1));
        }
    }
}
