package sprint4;

import java.util.HashMap;
import java.util.Map;

public class B {
    public static void main(String[] args) {
        char [] dictionary = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int len = 20;
        Map<Long, String> histories = new HashMap<>();
        iterate(dictionary, len, new StringBuilder(len), 0, histories);
    }
    public static void iterate(char [] dict, int len, StringBuilder line, int pos, Map<Long, String> histories ){
        check(line, histories);
        if (pos == len) {
            return;
        }

        for (char c : dict) {
            line.append(c);
            iterate(dict, len, line, pos + 1, histories);
            line.deleteCharAt(pos);
        }
    }

    private static void check(StringBuilder line, Map<Long, String> histories) {
        long hash = customHashCode(line);
        if (histories.containsKey(hash)){
            System.out.println(line + " " + histories.get(hash));
        } else {
            histories.put(hash, String.valueOf(line));
        }
    }

    private static long customHashCode(StringBuilder line) {
        if (line.length() == 0) return 0;
        char [] arr = line.toString().toCharArray();
        long hash = 0;
        for (int i = 0; i < arr.length; i++) {
            hash = (hash * (long) 1000 + (int) arr[i]) % 123987123;
        }
        return hash;
    }
}
