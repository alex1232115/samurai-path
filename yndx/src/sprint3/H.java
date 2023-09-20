package sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());

            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            biggestDigit(arr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void biggestDigit(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int itemToInsert = arr[i];
            int j = i;

            while (j > 0 && compareDigit(itemToInsert, arr[j - 1])) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = itemToInsert;
        }
        System.out.println(Arrays.toString(arr).replace("[", "").replace("]", "").replace(", ", ""));
    }

    private static boolean compareDigit(int o1, int o2) {
        return Integer.parseInt(String.valueOf(o1).concat(String.valueOf(o2))) > Integer.parseInt(String.valueOf(o2).concat(String.valueOf(o1)));
    }
}