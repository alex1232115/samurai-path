package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))){
//            long a = Integer.parseInt(rd.readLine()); // основание, по которому считается хеш.
//            int m = Integer.parseInt(rd.readLine()); // модуль.
            char [] line = rd.readLine().toCharArray(); // строка, cостоящая из больших и маленьких латинских букв.
            System.out.println(customHashCode(1000, 123987123, line));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static long customHashCode(long a, int m, char[] line) {
        if (line.length == 0) return 0;

        long hash = 0;
        for (int i = 0; i < line.length; ++i) {
            hash = (hash * a + (int)(line[i])) % m;
        }
        return hash;
    }
}
