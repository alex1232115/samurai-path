package sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        boolean sorted = true;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int a = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = a;
                    sorted = true;
                }
            }
            if (sorted) {
                System.out.println(Arrays.toString(arr).replace(",", "").replace("[", "").replace("]", ""));
                sorted = false;
            }
        }
        if (sorted) {
            System.out.println(Arrays.toString(arr).replace(",", "").replace("[", "").replace("]", ""));
        }
    }
}
