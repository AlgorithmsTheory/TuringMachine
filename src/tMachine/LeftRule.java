package tMachine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeftRule implements Comparable{
    public String sym;
    public String state;
    
    public LeftRule(String s, String  c){
        sym = c;
        state = s;
    }
    
    public LeftRule(String description){
        state = description.split("\\{")[0];
        sym = "";
        String chars = description.split("\\{")[1];
        char[] symbol = chars.toCharArray();
        for (int i = 0; i < chars.length() - 1; i++){
            if (symbol[i] != ','){
             sym += symbol[i];
            }
        }
    }
    
    @Override
    public int compareTo(Object o) {
        if ( o.getClass() != this.getClass() )
            return -1;
        LeftRule extra = (LeftRule)o;
        if ( !sym.equals(extra.sym) ) return sym.compareTo(extra.sym);
        return extra.state.compareTo(state);
    }
}
