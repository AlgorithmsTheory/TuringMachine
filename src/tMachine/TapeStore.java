package tMachine;

import java.util.ArrayList;
import java.util.Iterator;
import tMachine.RightRule.Motion;

public class TapeStore {
    ArrayList<Tape> tapes;
    
    public TapeStore(ArrayList<String> data){
        tapes = new ArrayList();
        Iterator<String> iter = data.iterator();
        while(iter.hasNext()) {
            tapes.add(new Tape(iter.next()));
        }
    }
    
    public String getInput() {
        String result = "";
        Iterator<Tape> iter = tapes.iterator();
        while(iter.hasNext()) {
            result += iter.next().getInput();
        }
        return result;
    }
    
    public void setOutput(String output) {
        int pos = 0;
        Iterator<Tape> iter = tapes.iterator();
        while(iter.hasNext()) {
            iter.next().setOutput(output.charAt(pos++));
        }
    }
    
    public void move(ArrayList<Motion> motions) {
        Iterator<Tape> tape = tapes.iterator();
        Iterator<Motion> motion = motions.iterator();
        while(tape.hasNext() && motion.hasNext()) {
            switch (motion.next()) {
                case Left:
                    tape.next().goLeft();
                    break;
                case Right:
                    tape.next().goRight();
                    break;
                default:
                    System.out.println("stop");
            }
        }
    }
    
    @Override
    public String toString() {
        String result = "";
        Iterator<Tape> iter = tapes.iterator();
        while(iter.hasNext()) {
            result += iter.next().toString() + " ";
        }
        return result;
    }
}
