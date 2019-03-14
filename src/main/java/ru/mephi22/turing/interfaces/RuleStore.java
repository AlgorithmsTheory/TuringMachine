package ru.mephi22.turing.interfaces;

import ru.mephi22.turing.LeftRule;
import ru.mephi22.turing.RightRule;

public interface RuleStore {
    void addRule(LeftRule leftRule, RightRule rightRule);
    RightRule getRule(String state, String symbol);
}