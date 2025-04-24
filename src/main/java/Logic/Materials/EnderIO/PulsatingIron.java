package Logic.Materials.EnderIO;

import Logic.Materials.Material;
import Logic.Abilities.Vanishing;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class PulsatingIron extends Material {
    public PulsatingIron() {
        super("Pulsating Iron", 6, MiningLevel.IRON, 2, 1.05);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 920;
            case HANDLE, EXTRA -> 250;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> abilities.add(new Vanishing(3));
            case HANDLE, EXTRA -> abilities.add(new Vanishing(1));
        }
    }
}
