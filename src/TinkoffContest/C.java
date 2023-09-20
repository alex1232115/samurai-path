package TinkoffContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer line = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(line.nextToken());
            int m = Integer.parseInt(line.nextToken());
            int q = Integer.parseInt(line.nextToken());
            int[][] maze = new int[n][m];
            for (int i = 0; i < n; i++) {
                char[] row = reader.readLine().replace(" ", "").toCharArray();
                for (int j = 0; j < m; j++) {
                    maze[i][j] = row[j] - '0';
                }
            }
            int[] answer = new int[q];
            for (int i = 0; i < q; i++) {
                int currentAnswer = 0;
                char[] currentRequest = reader.readLine().replace(" ", "").toCharArray();
                int currentRow = currentRequest[0] - '0' - 1;
                int currentCol = currentRequest[0] - '0' - 1;
                int currentBrave = currentRequest[2] - '0';
                for (int row = 0; row < n; row++) {
                    if (Math.abs(maze[currentRow][currentCol] - maze[row][currentCol]) <= currentBrave && row != currentRow) {
                        currentAnswer++;
                    }
                }
                for (int column = 0; column < m; column++) {
                    if (Math.abs(maze[currentRow][currentCol] - maze[currentRow][column]) <= currentBrave && column != currentCol) {
                        currentAnswer++;
                    }
                }
                answer[i] = currentAnswer;
            }

            for (int i = 0; i < q; i++) {
                System.out.println(answer[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
