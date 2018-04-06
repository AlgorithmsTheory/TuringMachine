package tMachine;

import java.util.ArrayList;


public class RightRule {
    public String state;
    public String sym;
    public ArrayList<Motion> motion;
    
    public RightRule(String c, Motion m, String st){
        sym = c;
        state = st;
//        motion = m;
    }
    
    public RightRule(String description){
        sym = "";
        String str = description.split("\\{", 2)[1];
        String[] strs = str.split("\\}", 2); 
        String chars = strs[0];  //getting symbols
        char[] symbol = chars.toCharArray();
        for (int i = 0; i < chars.length(); i++){
            if (symbol[i] != ','){
             sym += symbol[i];
            }
        }
        String str2 = strs[1];
        String str3 = str2.split("\\{", 2)[1];
        strs = str3.split("\\}", 2);
        String strMotions = strs[0];
        char[] motions = strMotions.toCharArray();
//        motion[] symbol = chars.toCharArray();
        motion = new ArrayList();
        for (int i = 0; i < strMotions.length(); i++){
            if (motions[i] != ','){
                switch(motions[i]){
                case 'L':
                    motion.add(Motion.Left);
                    break;
                case 'R':
                    motion.add(Motion.Right);
                    break;
                case 'H':
                    motion.add(Motion.NoMotion);
                    break;
                }
            }
        }  
        
        state = strs[1];
    }
    
    public enum Motion{
        Left,
        Right,
        NoMotion;
    }
}
