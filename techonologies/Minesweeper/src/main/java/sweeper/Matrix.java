package sweeper;

import java.util.Arrays;

class Matrix {
    private Box[][] matrix;

    Matrix(Box defaultBox) {
        matrix = new Box[Ranges.getSize().x][Ranges.getSize().y];
        for (Box[] box : matrix) {
            Arrays.fill(box, defaultBox);
        }
    }

    Box get(Coord coord) {
        if (Ranges.inRange(coord)) {
            return matrix[coord.x][coord.y];
        }
        return null;
    }

    void set(Coord coord, Box box) {
        if (Ranges.inRange(coord)) {
            matrix[coord.x][coord.y] = box;
        }
    }
}
