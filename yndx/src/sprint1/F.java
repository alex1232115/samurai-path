package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String in = reader.readLine().replaceAll("[^\\w]", "").toLowerCase(Locale.ROOT);
        System.out.println(checkPalindrome(in));
    }

    private static String checkPalindrome(String in) {
        char[] arr = in.toCharArray();
        int nose = 0;
        int tail = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[nose] != arr[tail]) {
                return "False";
            }
            nose++;
            tail--;
        }
        return "True";
    }
}
