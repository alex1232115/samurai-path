package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] first = reader.readLine().toCharArray();
        char[] shuffled = reader.readLine().toCharArray();

        System.out.println(findExcess(first, shuffled));
    }

    private static char findExcess(char[] first, char[] shuffled) {
        int sumFirst = 0;
        int sumShuffled = 0;

        for (int i = 0; i < first.length; i++) {
            sumFirst += first[i];
            sumShuffled += shuffled[i];
        }
        sumShuffled += shuffled[shuffled.length - 1];

        return (char) (sumShuffled - sumFirst);
    }
}
