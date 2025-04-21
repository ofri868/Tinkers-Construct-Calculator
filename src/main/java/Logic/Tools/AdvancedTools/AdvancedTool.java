package Logic.Tools.AdvancedTools;

import Logic.Parts.ToolPart;
import Logic.Tools.Tool;

public abstract class AdvancedTool extends Tool {
    protected final ToolPart extra1;
    protected final ToolPart extra2;
    public AdvancedTool(String toolName, ToolPart head, ToolPart handle, ToolPart extra1, ToolPart extra2){
        super(toolName, head, handle);
        this.extra1 = extra1;
        this.extra2 = extra2;
    }

    @Override
    public void calculateAbilities(){
        super.calculateAbilities();
        abilities.addAll(extra1.getMaterial().getAbilities());
        abilities.addAll(extra2.getMaterial().getAbilities());
    }
}
