package Logic.Materials.EnderIO;


import Logic.Abilities.Alien;
import Logic.Abilities.Enderference;
import Logic.Materials.Material;
import Logic.Abilities.Unnatural;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class EndSteel extends Material {
    public EndSteel() {
        super("End Steel", 8.25, MiningLevel.COBALT, 5, 0.9);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 400;
            case HANDLE, EXTRA -> 50;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type){
            case HEAD -> {
                abilities.add(new Enderference(1));
                abilities.add(new Alien(1));
            }
            case HANDLE, EXTRA -> abilities.add(new Unnatural(1));
        }
    }
}
