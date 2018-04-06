package tMachine;

import java.util.Map;
import java.util.TreeMap;
import tMachine.interfaces.RuleStore;


public class Rules implements RuleStore {
    protected Map<LeftRule, RightRule> rules;
    
    public Rules(){
        rules = new TreeMap();
    }
    
    @Override
    public void addRule(LeftRule sc, RightRule csm) {
        rules.put(sc, csm);
    }

    @Override
    public RightRule getRule(String state, String sym) {
        return rules.get(new LeftRule(state, sym));
    }
}
