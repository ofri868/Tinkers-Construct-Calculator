package Logic.Parts;

import Logic.Materials.Material;
import Logic.Utils.PartType;

public abstract class ToolPart {
    private final PartType partType;
    private final Material material;

    public ToolPart(PartType partType, Material material) {
        this.partType = partType;
        this.material = material;
        material.setDurability(partType);
    }
    public PartType getPartType() { return partType; }
    public Material getMaterial() { return material; }
}
