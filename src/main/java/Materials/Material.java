package Materials;
import java.util.List;

import Abilities.Ability;
import Utils.MiningLevel;
import Utils.PartType;


public abstract class Material {
    protected final String name;
    protected int durability;
    protected final double miningSpeed;
    protected final MiningLevel miningLevel;
    protected final double baseDamage;
    protected final double handleModifier;
    protected List<Ability> abilities;

    public Material(String name, double miningSpeed, Utils.MiningLevel miningLevel, double baseDamage, double handleModifier) {
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
