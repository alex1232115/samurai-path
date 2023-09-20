package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first = reader.readLine();
        String second = reader.readLine();

        System.out.println(binarySum(first,second));
    }

    private static StringBuilder binarySum(String first, String second) {
        StringBuilder string = new StringBuilder();
        int rest = 0;
        int length1 = first.length();
        int length2 = second.length();
        
        int maxLength = Math.max(length1,length2);

        for (int i = 0; i < maxLength; i++) {
            int firstDigit = i < first.length() ? first.charAt(first.length()-1-i) - '0' : 0;
            int secondDigit = i < second.length() ? second.charAt(second.length()-1-i)  - '0' : 0;

            int sum = firstDigit+secondDigit + rest;
            rest = sum/2;
            string.append(sum%2);
        }

        if (rest !=0) string.append("1");

        return string.reverse();
    }
}
