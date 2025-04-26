package Logic.Materials.ThermalExpansion;

import Logic.Abilities.Sharp;
import Logic.Abilities.Stiff;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class Steel extends Material {
    public Steel() {
        super("Steel", 7, MiningLevel.OBSIDIAN, 6, 0.9);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 540;
            case HANDLE -> 150;
            case EXTRA -> 25;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        switch (type) {
            case HEAD -> abilities.add(new Sharp(1));
            case HANDLE, EXTRA -> abilities.add(new Stiff(1));
        }
    }
}
