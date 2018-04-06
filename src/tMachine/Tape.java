package tMachine;

import tMachine.interfaces.InfiniteTape;

public class Tape implements InfiniteTape {

    public static char lambda = 955;
    String tape;
    int cpos;

    public Tape(String st) {
        tape = new String(st);
        cpos = 0;
    }

    @Override
    public char getInput() {
        return tape.charAt(cpos);
    }

    @Override
    public void setOutput(char sym) {
        char[] tmpgoof = tape.toCharArray();
        tmpgoof[cpos] = sym;
        tape = new String(tmpgoof);
    }

    @Override
    public void goLeft() {
        cpos--;
    }

    @Override
    public void goRight() {
        if (tape.length() - 1 == cpos) {
            tape += lambda;
        }
        cpos++;
    }

    @Override
    public String toString() {
        return tape.replaceAll(String.valueOf(lambda), "");
    }
}
