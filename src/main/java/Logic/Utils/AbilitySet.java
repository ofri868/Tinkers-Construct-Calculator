package Logic.Utils;

import Logic.Abilities.Ability;
import Logic.Abilities.StackableAbility;

import java.util.Iterator;
import java.util.TreeSet;

public class AbilitySet extends TreeSet<Ability> {
    public boolean add(StackableAbility ability){
        if (super.contains(ability)){
            Iterator<Ability> iter = super.iterator();
            while (iter.hasNext()){
                Ability a = iter.next();
                if (a.getClass().equals(ability.getClass())){
                    ((StackableAbility)a).setLevel(((StackableAbility) a).getLevel() + ability.getLevel());
                    return true;
                }
            }
        }
        return super.add(ability);
    }
}
