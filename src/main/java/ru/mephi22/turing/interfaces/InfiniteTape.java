package ru.mephi22.turing.interfaces;

public interface InfiniteTape {
    char getSymbol();
    void setSymbol(char symbol);
    void goLeft();
    void goRight();
}
