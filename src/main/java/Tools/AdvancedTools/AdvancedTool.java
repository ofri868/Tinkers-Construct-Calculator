package Tools.AdvancedTools;

import Parts.ToolPart;
import Tools.BasicTools.BasicTool;

public abstract class AdvancedTool extends BasicTool {
    protected final ToolPart extra;
    public AdvancedTool(String toolName, ToolPart head, ToolPart handle, ToolPart extra1, ToolPart extra2){
        super(toolName, head, handle, extra1);
        extra = extra2;
    }

    @Override
    public void calculateAbilities(){
        super.calculateAbilities();
        abilities.addAll(extra.getMaterial().getAbilities());
    }
}
