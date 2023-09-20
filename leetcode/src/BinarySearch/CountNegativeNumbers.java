package BinarySearch;

import java.util.Arrays;

public class CountNegativeNumbers {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(new CountNegativeNumbers().countNegatives(grid));
    }

    public int countNegatives(int[][] grid) {
        int output = 0;

        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
            int min = grid[i].length - 1;
            int max = 0;

            while (max <=min) {
                int mid = (max + min)/ 2;
                int current = grid[i][mid];

                if (current <= 0){
                    min = mid -1;
                } else {
                    max = mid+1;
                }

            }
            output+=min;
        }
        return output;
    }
}
