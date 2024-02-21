import seabattle.Game;
import seabattle.HumanPlayer;

public class JavaSeaBattle {
    public static void main(String[] args) {
        Game game = new Game(new HumanPlayer("Alexey"), new HumanPlayer("Valentin"));
        game.start();
    }
}
