package Logic.Parts.ToolParts.Handles;

import Logic.Materials.Material;
import Logic.Parts.ToolParts.ToolPart;
import Logic.Utils.PartType;

public abstract class Handle extends ToolPart {
    protected final double handleModifier;

    public Handle(String name, PartType partType, Material material) {
        super(name, partType, material);
        handleModifier = material.getHandleModifier();
    }

    public double getHandleModifier() {
        return handleModifier;
    }
}
