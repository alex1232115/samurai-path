package sprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            System.out.println(makeDiffTrees(n));
        }
    }

    private static int makeDiffTrees(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int countLeft = 0, countRight = 0, count = 0;

        for (int i = 0; i < n; i++) {
            countLeft = makeDiffTrees(i);
            countRight = makeDiffTrees(n - i - 1);
            count = count + countLeft * countRight;
        }
        return count;
    }
}
