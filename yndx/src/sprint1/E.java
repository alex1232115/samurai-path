package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        int max_length = 0;
        String longestWord = "";
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            String currentWord = stringTokenizer.nextToken();
            if (currentWord.length() > max_length) {
                longestWord = currentWord;
                max_length = longestWord.length();
            }
        }
        System.out.println(longestWord);
        System.out.println(max_length);
    }
}
