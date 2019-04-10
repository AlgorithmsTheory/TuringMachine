package ru.mephi22.turing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;

import org.json.*;
import ru.mephi22.turing.interfaces.RuleStore;

public class Main {

    public static void main(String[] argv) throws IOException, JSONException {
        byte[] encoded = Files.readAllBytes(Paths.get(argv[0]).toAbsolutePath());
        String data = new String(encoded, Charset.forName("UTF-8"));
        JSONObject obj = new JSONObject(data);
        
        TapeStore tapeStore = buildTapes(obj);
        RuleStore ruleStore = buildRules(obj);

        TuringMachine machine = new TuringMachine();
        machine.setRules(ruleStore);
        machine.setTapeStore(tapeStore);
        machine.run();
    }

    private static TapeStore buildTapes(JSONObject obj) {
        ArrayList<String> tapes = new ArrayList<>();
        JSONArray input = obj.getJSONArray("inputs");
        for (int i = 0; i < input.length(); ++i) {
            tapes.add(input.getString(i));
        }
        return new TapeStore(tapes);
    }

    private static RuleStore buildRules(JSONObject obj) {
        JSONArray rules = obj.getJSONArray("rules");
        RuleStore ruleStore = new Rules();
        for (int i = 0; i < rules.length(); ++i) {
            JSONObject rule = rules.getJSONObject(i);
            LeftRule leftRule = new LeftRule(rule.getJSONObject("source"));
            RightRule rightRule = new RightRule(rule.getJSONObject("destination"));
            ruleStore.addRule(leftRule, rightRule);
        }
        return ruleStore;
    }
}