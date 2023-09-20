package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class H {
    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            char[] str1 = rd.readLine().toCharArray();
            char[] str2 = rd.readLine().toCharArray();

            if (str1.length != str2.length) {
                System.out.println("NO");
            } else {
                System.out.println(strangeCompare(str1, str2));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String strangeCompare(char[] lessStr, char[] moreStr) {
        String answer = "YES";
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < lessStr.length; i++) {
            if (!map.containsKey(lessStr[i])) {
                if (!map.containsValue(moreStr[i])) {
                    map.put(lessStr[i], moreStr[i]);
                } else {
                    return "NO";
                }
            } else {
                if (map.get(lessStr[i]) != moreStr[i]) {
                    return "NO";
                }
            }
        }
        return answer;
    }
}
