package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            System.out.println(recursiveCommits(n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int recursiveCommits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }

        return recursiveCommits(n - 1) + recursiveCommits(n - 2);
    }
}
