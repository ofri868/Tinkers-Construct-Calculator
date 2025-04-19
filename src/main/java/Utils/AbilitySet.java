package Utils;

import Abilities.Ability;
import Abilities.StackableAbility;

import java.util.HashSet;
import java.util.Iterator;

public class AbilitySet extends HashSet<Ability> {
    public boolean add(StackableAbility ability){
        if (super.contains(ability)){
            int prevLevel = 0;
            Iterator<Ability> iter = super.iterator();
            while (iter.hasNext()){
                Ability a = iter.next();
                if (a.equals(ability)){
                    prevLevel = a.getLevel();
                    break;
                }
            }
            super.remove(ability);
            ability.setLevel(ability.getLevel()+prevLevel);
        }
        return super.add(ability);
    }
}
