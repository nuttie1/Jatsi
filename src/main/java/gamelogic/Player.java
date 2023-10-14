package gamelogic;

import java.util.ArrayList;


public class Player {
    private static final int MAX_DICE = 5;
    ArrayList<Die> dice = new ArrayList<Die>(MAX_DICE);
    String name;
    int score;

    YahtzeePoints yahtzeePoints;


    public Player(String name) {
        this.name = name;
        for (int i = 0; i < MAX_DICE; i++) {
            dice.add(new Die());
        }
        yahtzeePoints = new YahtzeePoints();
    }
    public void getAllPossibilities(){
        yahtzeePoints.checkPossibilities(dice);
    }

    public void setScore(){
        for(Die die : dice){
            score += die.getValue();
        }
    }
    public int getScore(){
        return score;
    }
    public void rollAll() {
        for (Die die : dice) {
            die.roll();
        }
    }
    public int getDieValue(int index) {
        return dice.get(index).getValue();
    }
    public void rollDie(int index) {
        dice.get(index).roll();
    }
    public void lockDie(int index) {
        dice.get(index).lock();
    }
    public void unLockDie(int index) {
        dice.get(index).unlock();
    }
    public void unlockAllDice() {
        for (Die die : dice) {
            die.unlock();
        }
    }
}
