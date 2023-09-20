package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            long a = Integer.parseInt(rd.readLine()); // основание, по которому считается хеш.
            long mod = Integer.parseInt(rd.readLine()); // модуль.
            char[] line = rd.readLine().toCharArray(); // строка, cостоящая из больших и маленьких латинских букв.
            int t = Integer.parseInt(rd.readLine());
            long[] hashArr = new long[line.length + 1];
            long[] powers = new long[line.length + 1];
            powers[0] = 1;
            for (int i = 1; i <= line.length; i++) {
                powers[i] = (powers[i - 1] * a) % mod;
            }
            for (int i = 1; i <= line.length; i++) {
                hashArr[i] = ((hashArr[i - 1] * a) + (long)line[i-1]) % mod;
            }

            for (int i = 0; i < t; i++) {
                StringTokenizer st = new StringTokenizer(rd.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                System.out.println(getHash(left, right, powers, hashArr, mod));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long getHash(int left, int right, long[] powers, long[] hashArr, long mod) {
        return (hashArr[right] + mod - (hashArr[left - 1] * powers[right - left]) % mod) % mod;
    }

}
