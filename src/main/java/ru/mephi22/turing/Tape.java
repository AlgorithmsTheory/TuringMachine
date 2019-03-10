package ru.mephi22.turing;

import ru.mephi22.turing.interfaces.InfiniteTape;

public class Tape implements InfiniteTape {

    private static final char LAMBDA = 955;
    private String tape;
    private int position;

    Tape(String st) {
        tape = st;
        position = 0;
    }

    @Override
    public char getSymbol() {
        return tape.charAt(position);
    }

    @Override
    public void setSymbol(char symbol) {
        char[] tmpgoof = tape.toCharArray();
        tmpgoof[position] = symbol;
        tape = new String(tmpgoof);
    }

    @Override
    public void goLeft() {
        position--;
    }

    @Override
    public void goRight() {
        if (tape.length() - 1 == position) {
            tape += LAMBDA;
        }
        position++;
    }

    @Override
    public String toString() {
        return tape.replaceAll(String.valueOf(LAMBDA), "");
    }
}
