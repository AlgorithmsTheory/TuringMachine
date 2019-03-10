package ru.mephi22.turing;

import ru.mephi22.turing.interfaces.RuleStore;

import java.util.Map;
import java.util.TreeMap;

public class Rules implements RuleStore {
    private Map<LeftRule, RightRule> rules;
    
    Rules(){
        rules = new TreeMap<>();
    }
    
    @Override
    public void addRule(LeftRule leftRule, RightRule rightRule) {
        rules.put(leftRule, rightRule);
    }

    @Override
    public RightRule getRule(String state, String symbol) {
        return rules.get(new LeftRule(state, symbol));
    }
}
