package ru.mephi22.turing;

import java.nio.charset.Charset;
import ru.mephi22.turing.interfaces.RuleStore;
import org.json.JSONObject;
import org.json.JSONArray;


public class TMachine {

    private String err = "error";
    //private String fin = "lambda";
    private String omega = "Ω";// ='937'

    protected String state;
    protected RuleStore rstore;
    protected TapeStore tape;
    final int max_step;

    public TMachine() {
        state = "S0";//₀";
        max_step = 10000;
    }

    public void run() {
        int cstep = 0;
        JSONObject report = new JSONObject();
        JSONArray logs = new JSONArray();
        //String tape = obj.getJSONObject("str").getString("pageName");
        while (!state.equals(err) && !state.equals(omega) && cstep++ < max_step) {
            nextStep();
            logs.put(state + ":" + tape.toString());
        }
        try {
            if (cstep >= max_step) {
                report.put("error", "too many steps");
            } else {
                report.put("error", "ok");
            }
            report.put("result", tape);
            report.put("logs", logs);
            report.put("cycle", cstep);
            
            byte[] res = report.toString().getBytes(Charset.forName("UTF-8"));
            
//            PrintWriter out = new PrintWriter("/tmp/out.txt");
//            out.println(Base64.getEncoder().encodeToString(res));
//            out.close();
            
            System.out.write(res, 0, res.length);
            
        } catch (Exception ex) {
            System.out.println("fatal error " + ex.getMessage());
        }
    }

    public void nextStep() {
        String input = tape.getInput();
        RightRule nRR = rstore.getRule(state, input);
        if (nRR == null) {
            state = omega;//state = fin;???
        } else {
            tape.setOutput(nRR.sym);
            state = nRR.state;
            tape.move(nRR.motion);
        }
    }

    public void setTape(TapeStore it) {
        tape = it;
    }

    public void setRules(RuleStore rs) {
        rstore = rs;
    }
}
