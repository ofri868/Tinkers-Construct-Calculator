package Tools.AdvancedTools;

import Parts.Part;
import Tools.BasicTools.BasicTool;

public abstract class AdvancedTool extends BasicTool {
    protected final Part extra;
    public AdvancedTool(String toolName, Part head, Part handle, Part extra1, Part extra2){
        super(toolName, head, handle, extra1);
        extra = extra2;
    }

    @Override
    public void calculateAbilities(){
        super.calculateAbilities();
        abilities.addAll(extra.getMaterial().getAbilities());
    }
}
