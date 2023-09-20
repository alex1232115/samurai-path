package sprint1.finaly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//86093080
public class B {
    private static final int LINES = 4;
    private static final int ITERATIONS = 10;

    public static void main(String[] args) {
        int maxS;
        char[] arr;
        int[] countSymbol = new int[10];

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            maxS = Integer.parseInt(reader.readLine()) * 2;
            for (int i = 0; i < LINES; i++) {
                arr = reader.readLine().toCharArray();
                for (char j : arr) {
                    if (j != '.') {
                        countSymbol[j - '0']++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(countMaxPoint(countSymbol, maxS));
    }

    private static int countMaxPoint(int[] countSymbol, int maxS) {
        int output = 0;

        for (int i = 0; i < ITERATIONS; i++) {
            if (countSymbol[i] <= maxS && countSymbol[i] > 0) {
                output++;
            }
        }
        return output;
    }
}