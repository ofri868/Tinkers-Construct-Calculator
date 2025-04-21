package Logic.Materials.Vanilla;

import Logic.Abilities.Aquadynamic;
import Logic.Abilities.Jagged;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Prismarine extends Material {
    public Prismarine() {
        super("Prismarine", 5.5, MiningLevel.IRON, 6.2, 0.6);
    }

    @Override
    public void setDurability(PartType type) {
        switch (type){
            case HEAD -> setDurability(430);
            case HANDLE -> setDurability(-150);
            case EXTRA -> setDurability(100);
        }
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> {
                abilities.add(new Aquadynamic(1));
                abilities.add(new Jagged(1));
            }
            case HANDLE, EXTRA -> abilities.add(new Aquadynamic(1));
        }
    }
}
