package Parts;

import Materials.Material;
import Utils.PartType;

public abstract class Part {
    private final PartType partType;
    private final Material material;

    public Part(PartType partType, Material material) {
        this.partType = partType;
        this.material = material;
        material.setDurability(partType);
    }
    public PartType getPartType() { return partType; }
    public Material getMaterial() { return material; }
}
