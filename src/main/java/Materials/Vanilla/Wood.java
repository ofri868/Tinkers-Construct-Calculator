package Materials.Vanilla;
import Abilities.Ecological;
import Materials.Material;
import Utils.MiningLevel;
import Utils.PartType;

public class Wood extends Material {
    public Wood() {
        super("Wood", 2, MiningLevel.STONE, 2, 1);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(35);
            case HANDLE -> setDurability(25);
            case EXTRA -> setDurability(15);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        addAbility(new Ecological(1));
    }
}
