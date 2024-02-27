package seabattle;

import java.util.Arrays;

public class Board {
    private Box[][] gameField;
    private final int MIN_COORD = 0;
    private final int MAX_COORD = 9;

    public Board(int size) {
        gameField = new Box[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(gameField[i], Box.WATER);
        }
    }

    public void setShipCoords(int[] coords, Ship ship) {
        //TODO метод №3
        switch (ship) {
            case BATTLESHIP -> {

            }
            case CRUISER -> {

            }
            case DESTROYER -> {

            }
            case TORPEDO_BOAT -> {

            }
        }
    }
}
