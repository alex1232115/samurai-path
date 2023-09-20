package sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] factors = new int[n];

            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                factors[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int m = Integer.parseInt(reader.readLine());
            int[] sizesCookies = new int[m];

            StringTokenizer stringTokenizer2 = new StringTokenizer(reader.readLine());
            for (int i = 0; i < m; i++) {
                sizesCookies[i] = Integer.parseInt(stringTokenizer2.nextToken());
            }
            System.out.println(happyCount(factors, sizesCookies));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int happyCount(int[] factors, int[] sizesCookies) {
        int output = 0;
        Arrays.sort(factors);
        Arrays.sort(sizesCookies);

        for (int i = 0, k = 0; i < factors.length && k < sizesCookies.length; ) {
            if (factors[i] <= sizesCookies[k]) {
                output++;
                i = i + 1;
            }
            k = k + 1;
        }
        return output;
    }
}