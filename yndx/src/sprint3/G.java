package sprint3;

import java.io.*;
import java.util.Arrays;

public class G {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(reader.readLine());
            char [] cloth = reader.readLine().replace(" ", "").toCharArray();
            countingSort(cloth, 3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void countingSort(char [] array, int k) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] countedValues = new int[k];
        for (char value : array) {
            countedValues[(value) - '0']++;
        }

        int index = 0;
        for (int value = 0; value < k; value++) {
            for (int amount = 0; amount < countedValues[value]; amount++) {
                array[index] = (char) ('0' + value);
                index++;
                writer.write(value + " ");
            }
        }
        writer.close();
    }
}
