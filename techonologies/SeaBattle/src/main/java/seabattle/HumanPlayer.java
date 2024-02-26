package seabattle;

public class HumanPlayer implements Player{
    private final String name;
    private final Board board;

    public HumanPlayer(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    @Override
    public void makeMove(Position position) {}

    protected Board getBoard() {
        return board;
    }
}
