package Tools.BasicTools;

import Parts.Part;
import Tools.Tool;

public abstract class BasicTool extends Tool {
    protected final Part extra;
    public BasicTool(String toolName, Part head, Part extra, Part handle) {
        super(toolName, head, handle);
        this.extra = extra;
    }
    @Override
    public void calculateAbilities(){
        super.calculateAbilities();
        abilities.addAll(extra.getMaterial().getAbilities());
    }
}
