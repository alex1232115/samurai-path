package seabattle;

public class HumanPlayer implements Player{
    private String name;
    private Board board;

    public HumanPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void makeMove(Position position) {

    }

    protected void setBoard(Board boardPlayer1) {
        board = boardPlayer1;
    }

    protected Board getBoard() {
        return board;
    }
}
