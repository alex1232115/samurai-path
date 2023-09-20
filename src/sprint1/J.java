package sprint1;

import java.io.*;

public class J {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int in = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorizeNumber(in));
    }

    private static StringBuilder factorizeNumber(int in) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 2; i <= in; ) {

            if (in % i == 0 && isPrime(i)) {
                stringBuilder.append(i).append(" ");
                in /= i;
            } else {
                i++;
            }
        }
        return stringBuilder;
    }

    private static boolean isPrime(int n) {
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) return false;
            i++;
        }
        return true;
    }
}
