package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(moduleFibonacci(n, k));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long moduleFibonacci(int n, int k) {

        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 1;
        }

        long firstCommit = 1;
        long secondCommit = 1;

        long currentCommit = 0;

        while (n > 1) {
            currentCommit = (long) ((firstCommit + secondCommit) % Math.pow(10, k));

            secondCommit = firstCommit;

            firstCommit = currentCommit;

            n--;
        }

        return currentCommit;
    }
}
