package sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            char [] arr1 = reader.readLine().toCharArray();
            char [] arr2 = reader.readLine().toCharArray();

            System.out.println(findSequence(arr1,arr2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String findSequence(char[] arr1, char[] arr2) {
        int k = 0;
        for (char c : arr2) {
            if (k < arr1.length && c == arr1[k]) {
                k++;
            }
        }
        String output;
        return output = (k == arr1.length) ? "True": "False";
    }
}
