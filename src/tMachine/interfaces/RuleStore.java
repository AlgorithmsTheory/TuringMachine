package tMachine.interfaces;

import tMachine.RightRule;
import tMachine.LeftRule;

public interface RuleStore {
    public void addRule( LeftRule cs, RightRule csm);
    public RightRule getRule(String state, String sym);
}