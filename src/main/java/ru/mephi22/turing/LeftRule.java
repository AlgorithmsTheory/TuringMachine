package ru.mephi22.turing;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.json.JSONObject;
import org.json.JSONArray;

@EqualsAndHashCode
@AllArgsConstructor
public class LeftRule implements Comparable {
    private final String state;
    private final String symbol;
    
    LeftRule(JSONObject jsonInput) {
        this.state = jsonInput.getString("state");

        JSONArray symbolArray = jsonInput.getJSONArray("symbols");
        StringBuilder symBuilder = new StringBuilder();
        for (int i = 0; i < symbolArray.length(); i++) {
            symBuilder.append(symbolArray.getString(i));
        }
        this.symbol = symBuilder.toString();
    }
    
    @Override
    public int compareTo(Object o) {
        if ( o.getClass() != this.getClass() )
            return -1;
        LeftRule extra = (LeftRule)o;
        if ( !symbol.equals(extra.symbol) ) return symbol.compareTo(extra.symbol);
        return extra.state.compareTo(state);
    }
}
