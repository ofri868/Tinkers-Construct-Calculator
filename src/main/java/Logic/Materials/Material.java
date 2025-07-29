package Logic.Materials;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Logic.Abilities.Ability;
import Logic.Utils.MiningLevel;
import Logic.Utils.PartType;


public abstract class Material {
    protected final String name;
    protected final double miningSpeed;
    protected final MiningLevel miningLevel;
    protected final double baseDamage;
    protected final double handleModifier;
    protected List<Ability> abilities;
    public static final List<String> ENDERIO_MATERIALS = Arrays.asList(
            "Conductive Iron", "Dark Steel", "Electrical Steel", "End Steel", "Energetic Alloy",
            "Pulsating Iron", "Redstone Alloy", "Soularium", "Vibrant Alloy"
    );
    public static final List<String> TINKERS_CONSTRUCT_MATERIALS = Arrays.asList(
            "Ardite", "Blue Slime", "Cobalt", "Knightslime", "Magma Slime", "Manyullyn", "Pig Iron"
            );
    public static final List<String> EXTRA_UTILITIES_MATERIALS = Arrays.asList(
            "Demonic Metal", "Enchanted Metal", "Evil Infused Iron", "Magical Wood"
    );
    public static final List<String> INDUSTRIAL_FOREGOING_MATERIALS = Arrays.asList(
            "Pink Slime", "Plastic", "Reinforced Pink Slime"
    );
    public static final List<String> THERMAL_EXPANSION_MATERIALS = Arrays.asList(
            "Bronze", "Copper", "Electrum", "Lead", "Silver", "Steel"
    );
    public static final List<String> THE_TWILIGHT_FOREST_MATERIALS = Arrays.asList(
            "Fiery Ingot", "Knightmetal Ingot", "Naga Scale", "Steeleaf"
    );
    public static final List<String> VANILLA_MATERIALS = Arrays.asList(
            "Bone", "Cactus", "End Stone", "Flint", "Iron", "Netherrack", "Obsidian", "Paper",
            "Prismarine", "Slime", "Sponge", "Stone", "Wood"
            );
    public static final List<String> OTHER_MATERIALS = Arrays.asList(
            "Constantan", "Corrupted", "Firewood", "Iron Alloy", "Treated Wood"
    );


    public Material(String name, double miningSpeed, MiningLevel miningLevel, double baseDamage, double handleModifier) {
        this.name = name;
        this.miningSpeed = miningSpeed;
        this.miningLevel = miningLevel;
        this.baseDamage = baseDamage;
        this.handleModifier = handleModifier;
        abilities = new ArrayList<>();
    }
    public String getName(){return name;}
    public abstract int getDurability(PartType type);
    public double getMiningSpeed(){return miningSpeed;}
    public MiningLevel getMiningLevel(){return miningLevel;}
    public double getBaseDamage(){return baseDamage;}
    public double getHandleModifier(){return handleModifier;}
    public List<Ability> getAbilities(){return abilities;}
    public abstract void setAbilities(PartType type);
    public void addAbility(Ability ability){abilities.add(ability);}
    public static Material createMaterialInstance(String materialName) {
        List<String> availablePackages = Arrays.asList("EnderIO", "ExtraUtilities", "IndustrialForegoing", "Others", "ThermalExpansion", "TheTwilightForest", "TinkersConstruct", "Vanilla");
        for(String packageName : availablePackages) {
            // Remove spaces to match class name
            String className = materialName.replace(" ", "");
            // Full package path to your material classes
            String fullClassName = "Logic.Materials." + packageName + "." + className;
            // Load the class and instantiate it
            Class<?> clazz;
            try {
                clazz = Class.forName(fullClassName);
            }
            catch (ClassNotFoundException e) {
                continue;
            }
            try {
                if(Material.class.isAssignableFrom(clazz)) return (Material) clazz.getDeclaredConstructor().newInstance();
                else throw new IllegalArgumentException("Class " + className + " is not a subclass of Material");
            }
            catch (Exception e) {
                throw new IllegalArgumentException("material not found!");
            }
        }
        throw new IllegalArgumentException("material not found!");
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Material) {
            return name.equals(((Material) obj).name);
        }
        return false;
    }
}
