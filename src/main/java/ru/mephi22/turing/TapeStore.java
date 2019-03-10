package ru.mephi22.turing;

import java.util.ArrayList;
import java.util.Iterator;

import static ru.mephi22.turing.RightRule.Motion;

public class TapeStore {
    private ArrayList<Tape> tapes;
    
    TapeStore(ArrayList<String> data){
        tapes = new ArrayList<>();
        for (String aData : data) {
            tapes.add(new Tape(aData));
        }
    }
    
    String getInput() {
        StringBuilder result = new StringBuilder();
        for (Tape tape : tapes) {
            result.append(tape.getSymbol());
        }
        return result.toString();
    }
    
    void setOutput(String output) {
        int pos = 0;
        for (Tape tape : tapes) {
            tape.setSymbol(output.charAt(pos++));
        }
    }
    
    void move(ArrayList<Motion> motions) {
        Iterator<Tape> tape = tapes.iterator();
        Iterator<Motion> motion = motions.iterator();
        while(tape.hasNext() && motion.hasNext()) {
            switch (motion.next()) {
                case LEFT:
                    tape.next().goLeft();
                    break;
                case RIGHT:
                    tape.next().goRight();
                    break;
                default:
                    System.out.println("stop");
            }
        }
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Tape tape : tapes) result.append(tape.toString()).append(" ");
        return result.toString();
    }
}
