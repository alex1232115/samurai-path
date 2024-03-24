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

    public void setShipCoords(Ship ship) {
        //TODO метод №3

    }
}
