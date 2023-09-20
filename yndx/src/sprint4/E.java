package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))){
            char [] line = rd.readLine().toCharArray();
            int maxLength = 0;
            int prev = 0;
            int [] history = new int [256];
            for (int i = 0; i < line.length; i++) {
                prev = Math.max(prev, history[line[i]]);
                history[line[i]] = i + 1;
                maxLength = Math.max(maxLength, i + 1 - prev);
            }
            System.out.println(maxLength);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
