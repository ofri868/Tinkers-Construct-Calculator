package Logic.Materials.IndustrialForegoing;

import Logic.Abilities.Dense;
import Logic.Abilities.Slimey;
import Logic.Abilities.Unnatural;
import Logic.Materials.Material;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;

public class ReinforcedPinkSlime extends Material {
    public ReinforcedPinkSlime(){
        super("Reinforced Pink Slime", 7.5, MiningLevel.DIAMOND, 5.5, 3.2);
    }

    @Override
    public int getDurability(PartType type) {
        return switch (type) {
            case HEAD -> 2800;
            case HANDLE -> 2350;
            case EXTRA -> 270;
        };
    }

    @Override
    public void setAbilities(PartType type) {
        abilities.add(new Slimey(1));
        switch (type) {
            case HEAD -> abilities.add(new Dense(1));
            case HANDLE, EXTRA -> abilities.add(new Unnatural(1));
        }

    }
}
