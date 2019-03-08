package ru.mephi22.turing;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.*;
import ru.mephi22.turing.interfaces.RuleStore;

public class Main {

    public static void main(String[] argv) throws IOException, JSONException {
        byte[] encoded = Files.readAllBytes(Paths.get(argv[0]).toAbsolutePath());
        String data = new String(encoded, Charset.forName("UTF-8"));
        JSONObject obj = new JSONObject(data);
        
        // build tapes
        ArrayList<String> tapes = new ArrayList<>();
        JSONArray input = obj.getJSONArray("str");
        for (int i = 0; i < input.length(); ++i) {
            tapes.add(input.getString(i));
        }
        TapeStore tapeStore = new TapeStore(tapes);
        
        // build rules
        JSONArray rules = obj.getJSONArray("rule");
        RuleStore ruleStore = new Rules();
        for (int i = 0; i < rules.length(); ++i) {
            JSONObject rule = rules.getJSONObject(i);
            LeftRule l = new LeftRule(rule.getString("src"));
            RightRule r = new RightRule(rule.getString("dst"));
            ruleStore.addRule(l, r);
        }
        
        TMachine machine = new TMachine();

        machine.setRules(ruleStore);
        machine.setTape(tapeStore);
        machine.run();
    }
}