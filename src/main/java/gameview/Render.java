package gameview;



public class Render {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void print(String text, Colour colour) {
        System.out.println(colour + text + Colour.RESET);
    }
}
