package gamelogic;

public class Die {
    int value;
    boolean locked;
    public int roll() {
        if(!locked){
            value = (int) (Math.random() * 6 + 1);
            return value;
        } else {
            return -1;
        }
    }
    public int getValue() {
        return value;
    }
    public void lock() {
        locked = true;
    }
    public void unlock() {
        locked = false;
    }
}
