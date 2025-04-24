package Logic.Parts;

import Logic.Materials.Material;
import Logic.Utils.PartType;

public class ToolPart {
    private final PartType partType;
    private final Material material;

    public ToolPart(PartType partType, Material material) {
        this.partType = partType;
        this.material = material;
        material.setDurability(partType);
        material.setAbilities(partType);
    }
    public PartType getPartType() { return partType; }
    public Material getMaterial() { return material; }

    @Override
    public String toString() {
        return partType.toString() + ": " + material.toString();
    }
}
