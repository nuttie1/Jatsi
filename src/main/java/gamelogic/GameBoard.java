package gamelogic;

import java.util.Scanner;

public class GameBoard {
    private static final int PLAYER_COUNT = 1;
    private static final int MAX_ROUND = 13 * PLAYER_COUNT;
    Scanner scanner = new Scanner(System.in);
    Player player;

    public GameBoard() {
        player = new Player("Player 1");
    }
    public void startGame(){
        gameLoop();
    }
    private void gameLoop() {
        for(int i = 0; i < MAX_ROUND; i++){

        }
    }
}
