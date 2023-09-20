package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class L {
    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer st = new StringTokenizer(rd.readLine());
            int length = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            char [] line = rd.readLine().toCharArray();
            int hash = customHashCode(1000, 1000000009, line, length);

            mnogoGosha(length, amount, line, hash);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void mnogoGosha(int length, int amount, char[] line, int hash) {
        Map<Integer, Integer> hash_amount = new HashMap<>();
        Map<Integer, Integer> hash_positions = new HashMap<>();
        hash_amount.put(hash, 1);
        hash_positions.put(hash, 0);
        for (int i = 1; i < line.length - length; i++) {
            hash = getHash(1000, 1000000009, hash, i - 1, i + length, line);
            if (hash_amount.containsKey(hash) && hash_amount.get(hash) == amount){
                System.out.println(hash_positions.get(hash));
            } else if (hash_amount.containsKey(hash) && hash_amount.get(hash) != amount){
                hash_amount.replace(hash, hash_amount.get(hash) + 1);
            } else {
                hash_amount.put(hash, 1);
                hash_positions.put(hash, i);
            }
        }
    }
    private static int customHashCode(int a, int m, char[] line, int len) {
        if (line.length == 0) return 0;

        long hash = 0;
        for (int i = 0; i < len; ++i) {
            hash = (hash * a + (int)(line[i])) % m;
        }
        return (int)hash;
    }
    private static int getHash(int a, int m, int baseHash, int left, int right, char [] line){
        return (int) (((baseHash - line[left] * Math.pow(a ,right-left) % m) * a + line[right]) % m);
    }
}
