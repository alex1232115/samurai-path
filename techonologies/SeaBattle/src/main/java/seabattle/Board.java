package seabattle;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private Box[][] gameField;

    public Board(int size) {
        gameField = new Box[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(gameField[i], Box.WATER);
        }
    }

    public void fillBoardByHuman() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты 4-х палубоного корабля (формат: x,y;x,y;x,y;x,y)");
        String line = scanner.nextLine();
        //TODO доделать метод заполнения игрового поля
    }
}
