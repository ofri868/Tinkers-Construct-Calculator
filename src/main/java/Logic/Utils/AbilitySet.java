package Logic.Utils;

import Logic.Abilities.Ability;
import Logic.Abilities.StackableAbility;

import java.util.HashSet;
import java.util.Iterator;

public class AbilitySet extends HashSet<Ability> {
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
