package Logic.Parts.ToolParts;

import Logic.Materials.Material;
import Logic.Utils.PartType;

public abstract class ToolPart {
    protected final String name;
    protected int durability;
    protected final PartType partType;
    protected final Material material;

    public ToolPart(String name, PartType partType, Material material) {
        this.name = name;
        this.partType = partType;
        this.material = material;
        durability = material.getDurability(partType);
    }
    public PartType getPartType() { return partType; }
    public Material getMaterial() { return material; }
    public String getName() { return name; }
    public int getDurability() { return durability; }

    @Override
    public String toString() {
        return material.toString() + " " + name;
    }
}
