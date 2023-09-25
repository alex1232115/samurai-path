package sprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class I {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
//            long startTime = System.currentTimeMillis();
//            System.out.println(makeDiffTrees(n));
//            long endTime = System.currentTimeMillis();
//            System.out.println("Brute force approach took " + (endTime - startTime) + " milliseconds");

            long startTime = System.currentTimeMillis();
            int [] count = new int [n + 1];
            Arrays.fill(count, -1);
            int result = countUniqueBst(n, count);
            System.out.println(result);
            long endTime = System.currentTimeMillis();
            System.out.println("Dynamic programming took " + (endTime - startTime) + " milliseconds");
        }
    }

    private static int makeDiffTrees(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int countLeft, countRight, count = 0;

        for (int i = 1; i <= n; i++) {
            countLeft = makeDiffTrees(i - 1);
            countRight = makeDiffTrees(n - i);
            count = count + countLeft * countRight;
        }
        return count;
    }
    private static int countUniqueBst(int n, int [] count) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (count[n] != -1) {
            return count[n];
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = res + countUniqueBst(i - 1, count) * countUniqueBst(n - i, count);
        }
        count[n] = res;
        return res;
    }
}
