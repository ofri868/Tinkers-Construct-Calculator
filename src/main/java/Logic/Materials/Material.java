package Logic.Materials;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Logic.Abilities.Ability;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;


public abstract class Material {
    protected final String name;
    protected int durability;
    protected final double miningSpeed;
    protected final MiningLevel miningLevel;
    protected final double baseDamage;
    protected final double handleModifier;
    protected List<Ability> abilities;
    public static final List<String> MATERIALS = Arrays.asList(
            "Electrical Steel", "Energetic Alloy", "Vibrant Alloy", "Redstone Alloy", "Conductive Iron",
            "Pulsating Iron", "Dark Steel", "Soularium", "End Steel", "Iron Alloy", "Naga Scale",
            "Steeleaf", "Fiery Ingot", "Knightmetal Ingot", "Wood", "Stone", "Flint", "Cactus", "Bone",
            "Obsidian", "Prismarine", "End Stone", "Paper", "Sponge", "Firewood", "Iron",
            "Pig Iron", "Knightslime", "Slime", "Blue Slime", "Magma Slime", "Netherrack",
            "Cobalt", "Ardite", "Manyullyn", "Copper", "Bronze", "Lead", "Silver", "Electrum", "Steel",
            "Treated Wood", "Constantan", "Magical Wood", "Evil Infused Iron", "Enchanted Metal",
            "Demonic Metal", "Plastic", "Pink Slime", "Reinforced Pink Slime", "Corrupted"
    );

    public Material(String name, double miningSpeed, MiningLevel miningLevel, double baseDamage, double handleModifier) {
        this.name = name;
        this.miningSpeed = miningSpeed;
        this.miningLevel = miningLevel;
        this.baseDamage = baseDamage;
        this.handleModifier = handleModifier;
    }
    public String getName(){return name;}
    public int getDurability(){return durability;}
    public abstract void setDurability(PartType type);
    public void setDurability(int durability) {this.durability = durability;}
    public double getMiningSpeed(){return miningSpeed;}
    public MiningLevel getMiningLevel(){return miningLevel;}
    public double getBaseDamage(){return baseDamage;}
    public double getHandleModifier(){return handleModifier;}
    public List<Ability> getAbilities(){return abilities;}
    public abstract void setAbilities(PartType type);
    public void addAbility(Ability ability){abilities.add(ability);}
}
