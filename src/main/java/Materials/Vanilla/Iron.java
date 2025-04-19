package Materials.Vanilla;
import Abilities.Crude;
import Abilities.Lightweight;
import Abilities.Magnetic;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;


public class Iron extends Material {
    public Iron(){
        super("iron", 6, MiningLevel.DIAMOND, 2, 0.85);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(204);
            case HANDLE -> setDurability(60);
            case EXTRA -> setDurability(50);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Magnetic(2));
            case HANDLE, EXTRA -> abilities.add(new Magnetic(1));
        }
    }
}
