package seabattle;

public class Game {
    private GameState gameState;
    private Board boardPlayer1;
    private Board boardPlayer2;
    private final HumanPlayer player1;
    private final HumanPlayer player2;

    public Game(HumanPlayer player1, HumanPlayer player2) {
        gameState = GameState.PLAYED;
        boardPlayer1 = new Board(10);
        boardPlayer2 = new Board(10);
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * запуск логики игры
     */
    public void start() {
        System.out.println("Добро пожаловать в игру МОРСКОЙ БОЙ БИТВА СЕМИ МОРЕЙ \n" +
                "Перед стартом игры каждый из игроков должен проставить свои корабли, первым начинает игрок1: " + player1.getName() +
                ". Второй игрок, не смотри!");
        boardPlayer1.fillBoardByHuman();
        player1.setBoard(boardPlayer1);
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
