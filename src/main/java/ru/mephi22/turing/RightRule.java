package ru.mephi22.turing;

import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

@Getter
public class RightRule {
    private String state;
    private String symbol;
    private ArrayList<Motion> motion;

    RightRule(JSONObject jsonInput){

        this.state = jsonInput.getString("state");

        JSONArray symbolArray = jsonInput.getJSONArray("symbols");
        StringBuilder symBuilder = new StringBuilder();
        for (int i = 0; i < symbolArray.length(); i++) {
            symBuilder.append(symbolArray.getString(i));
        }
        this.symbol = symBuilder.toString();

        JSONArray motionArray = jsonInput.getJSONArray("moves");
        motion = new ArrayList<>();
        for (int i = 0; i < motionArray.length(); i++){
                switch(motionArray.getString(i)){
                    case "L":
                        motion.add(Motion.LEFT);
                        break;
                    case "R":
                        motion.add(Motion.RIGHT);
                        break;
                    case "H":
                        motion.add(Motion.HOLD);
                        break;
                }
            }
    }

    public enum Motion {
        LEFT,
        RIGHT,
        HOLD
    }
}
