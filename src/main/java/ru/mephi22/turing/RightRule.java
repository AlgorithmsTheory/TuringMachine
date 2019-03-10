package ru.mephi22.turing;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class RightRule {
    private String state;
    private String sym;
    private ArrayList<Motion> motion;
    
    RightRule(String description){
        StringBuilder symBuilder = new StringBuilder();
        String str = description.split("\\{", 2)[1];
        String[] strs = str.split("}", 2);
        String chars = strs[0];  //getting symbols
        char[] symbol = chars.toCharArray();
        for (int i = 0; i < chars.length(); i++){
            if (symbol[i] != ','){
             symBuilder.append(symbol[i]);
            }
        }
        sym = symBuilder.toString();
        String str2 = strs[1];
        String str3 = str2.split("\\{", 2)[1];
        strs = str3.split("\\}", 2);
        String strMotions = strs[0];
        char[] motions = strMotions.toCharArray();
        motion = new ArrayList<>();
        for (int i = 0; i < strMotions.length(); i++){
            if (motions[i] != ','){
                switch(motions[i]){
                case 'L':
                    motion.add(Motion.LEFT);
                    break;
                case 'R':
                    motion.add(Motion.RIGHT);
                    break;
                case 'H':
                    motion.add(Motion.HOLD);
                    break;
                }
            }
        }  
        
        state = strs[1];
    }
    
    public enum Motion {
        LEFT,
        RIGHT,
        HOLD
    }
}
