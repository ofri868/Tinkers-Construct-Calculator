package Tools.BasicTools;

import Parts.ToolPart;
import Tools.Tool;

public abstract class BasicTool extends Tool {
    protected final ToolPart extra;
    public BasicTool(String toolName, ToolPart head, ToolPart extra, ToolPart handle) {
        super(toolName, head, handle);
        this.extra = extra;
    }
    @Override
    public void calculateAbilities(){
        super.calculateAbilities();
        abilities.addAll(extra.getMaterial().getAbilities());
    }
}
