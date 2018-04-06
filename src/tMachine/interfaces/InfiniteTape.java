package tMachine.interfaces;

public interface InfiniteTape {
    public char getInput();
    public void setOutput(char sym);
    public void goLeft();
    public void goRight();
}
