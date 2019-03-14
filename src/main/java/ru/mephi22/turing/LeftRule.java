package ru.mephi22.turing;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class LeftRule implements Comparable {
    private final String state;
    private final String symbol;
    
    LeftRule(String description) {
        String[] splittedDescription = description.split("\\{");
        state = splittedDescription[0];
        StringBuilder symBuilder = new StringBuilder();
        String chars = description.split("\\{")[1];
        char[] symbol = chars.toCharArray();
        for (int i = 0; i < chars.length() - 1; i++){
            if (symbol[i] != ','){
             symBuilder.append(symbol[i]);
            }
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
