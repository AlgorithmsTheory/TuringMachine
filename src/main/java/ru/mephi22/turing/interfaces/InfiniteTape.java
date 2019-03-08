package ru.mephi22.turing.interfaces;

public interface InfiniteTape {
    char getInput();
    void setOutput(char sym);
    void goLeft();
    void goRight();
}
