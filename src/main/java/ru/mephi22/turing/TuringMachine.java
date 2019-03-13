package ru.mephi22.turing;

import java.nio.charset.Charset;
import ru.mephi22.turing.interfaces.RuleStore;
import org.json.JSONObject;
import org.json.JSONArray;

final class TuringMachine {

    private static final String ERROR = "error";
    private static final String OMEGA = "Ω";// ='937'
    private static final int MAX_STEP = 10_000;

    private String state;
    private RuleStore ruleStore;
    private TapeStore tapeStore;

    TuringMachine() {
        state = "S0";
    }

    void run() {
        int step = 0;
        JSONObject report = new JSONObject();
        JSONArray logs = new JSONArray();
        while (!state.equals(ERROR) && !state.equals(OMEGA) && step++ < MAX_STEP) {
            nextStep();
            logs.put(state + ":" + tapeStore.toString());
        }
        try {
            if (step >= MAX_STEP) {
                report.put("error", "too many steps");
            } else {
                report.put("error", "ok");
            }
            report.put("result", tapeStore);
            report.put("logs", logs);
            report.put("cycle", step);
            
            byte[] res = report.toString().getBytes(Charset.forName("UTF-8"));
            
            System.out.write(res, 0, res.length);
            
        } catch (RuntimeException ex) {
            System.out.println("fatal error " + ex.getMessage());
        }
    }

    private void nextStep() {
        String symbol = tapeStore.getInput();
        RightRule rightRule = ruleStore.getRule(state, symbol);
        if (rightRule == null) {
            state = OMEGA;
        } else {
            tapeStore.setOutput(rightRule.getSym());
            state = rightRule.getState();
            tapeStore.move(rightRule.getMotion());
        }
    }

    void setTapeStore(TapeStore it) {
        tapeStore = it;
    }

    void setRules(RuleStore rs) {
        ruleStore = rs;
    }
}
