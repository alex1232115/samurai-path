package sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            genBracket(n * 2, "", n, 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void genBracket(int n, String prefix, int sourceOpen, int sourceClose) {
        if (sourceClose == 0 && sourceOpen == 0) {
            System.out.println(prefix);
            return;
        }
        if (sourceOpen > 0) {
            genBracket(n - 1, prefix + "(", sourceOpen - 1, sourceClose + 1);
        }
        if (sourceClose > 0) {
            genBracket(n - 1, prefix + ")", sourceOpen, sourceClose - 1);
        }
    }
}
