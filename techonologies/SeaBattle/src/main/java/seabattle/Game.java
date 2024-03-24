package seabattle;

import seabattle.ships.Battleship;

import java.util.Scanner;

public class Game {
    private GameState gameState;
    private GameType gameType;
    private final Board board1;
    private final Board board2;
    private HumanPlayer player1;
    private HumanPlayer player2;

    /**
     * игрок vs игрок
     */
    public Game(String name1, String name2) {
        gameState = GameState.CREATED;
        board1 = new Board(10);
        board2 = new Board(10);
        gameType = GameType.HUMAN_GAME;
        player1 = new HumanPlayer(name1, board1);
        player2 = new HumanPlayer(name2, board2);
    }

    /**
     * игрок vs компьютер
     */
    public Game(String name1) {
        gameState = GameState.CREATED;
        board1 = new Board(10);
        board2 = new Board(10);
        gameType = GameType.HUMAN_VS_COMPUTER;
        player1 = new HumanPlayer(name1, board1);
        player2 = null;
    }

    /**
     * запуск логики игры
     */
    public void start() {
        System.out.println("Добро пожаловать в игру МОРСКОЙ БОЙ БИТВА СЕМИ МОРЕЙ \n" +
                "Перед стартом игры каждый из игроков должен проставить свои корабли, первым начинает игрока №1: " + player1.getName() +
                ". Игрок №2, не смотри!");
        initPlayerBoard(board1);
        System.out.println("Сейчас очередь игрока №2: " + player2.getName() + "Игрок №1, не смотри!");
        initPlayerBoard(board2);
        gameState = GameState.PLAYED;
    }

    private void initPlayerBoard(Board board) {
        Battleship battleship = new Battleship();
        initShip(board, Ship.BATTLESHIP, 1);
        for (int i = 0; i < 2; i++) {
            initShip(board, Ship.CRUISER, i);
        }
        for (int i = 0; i < 3; i++) {
            initShip(board, Ship.DESTROYER, i);
        }
        for (int i = 0; i < 4; i++) {
            initShip(board, Ship.TORPEDO_BOAT, i);
        }
    }


    //TODO переделать этот пиздец https://proglib.io/p/udalite-iz-koda-if-else-i-switch-case-2021-06-02
    private void initShip(Board board, Ship ship, int num) {
        Scanner scanner = new Scanner(System.in);
        switch (ship) {
            case BATTLESHIP -> {
                while (true) {
                    System.out.println("Введите координаты 4-х палубоного корабля (формат: x,y;x,y;x,y;x,y)");
                    String input = scanner.nextLine();
                    if (checkCorrectInput(input, ship)) {
                        board.setShipCoords(convertCoords(input), ship);
                        break;
                    }
                }
            }
            case CRUISER -> {
                while (true) {
                    System.out.println("Введите координаты " + (num + 1) + "-го 3-х палубоного корабля (формат: x,y;x,y;x,y;)");
                    String input = scanner.nextLine();
                    if (checkCorrectInput(input, ship)) {
                        board.setShipCoords(convertCoords(input), ship);
                        break;
                    }
                }
            }
            case DESTROYER -> {
                while (true) {
                    System.out.println("Введите координаты " + (num + 1) + "-го 2-х палубоного корабля (формат: x,y;x,y;)");
                    String input = scanner.nextLine();
                    if (checkCorrectInput(input, ship)) {
                        board.setShipCoords(convertCoords(input), ship);
                        break;
                    }
                }
            }
            case TORPEDO_BOAT -> {
                while (true) {
                    System.out.println("Введите координаты " + (num + 1) + "-го однопалубоного корабля (формат: x,y;)");
                    String input = scanner.nextLine();
                    if (checkCorrectInput(input, ship)) {
                        board.setShipCoords(convertCoords(input), ship);
                        break;
                    }
                }
            }
        }

    }

    private int[] convertCoords(String input) {
        //TODO метод №1
        return null;
    }

    private boolean checkCorrectInput(String input, Ship ship) {
        //TODO метод №2

        return true;
    }

    public GameState getGameState() {
        return gameState;
    }
}
