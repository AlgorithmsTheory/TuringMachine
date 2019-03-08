package ru.mephi22.turing.interfaces;

import ru.mephi22.turing.LeftRule;
import ru.mephi22.turing.RightRule;

public interface RuleStore {
    void addRule(LeftRule cs, RightRule csm);
    RightRule getRule(String state, String sym);
}