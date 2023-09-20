package sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer line1 = new StringTokenizer(reader.readLine());

            int housNumber = Integer.parseInt(line1.nextToken());
            int k = Integer.parseInt(line1.nextToken());

            StringTokenizer line2 = new StringTokenizer(reader.readLine());
            int [] housPrices = new int [line2.countTokens()];
            for (int i = 0; i < housPrices.length; i++) {
                housPrices[i] = Integer.parseInt(line2.nextToken());
            }

            buyHouses(housNumber, k, housPrices);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void buyHouses(int n, int budget, int[] housPrices) {
        int total = 0;
        Arrays.sort(housPrices);
        for (int i = 0; i < housPrices.length; i++) {
            if (housPrices[i] <=budget){
                budget-=housPrices[i];
                total++;
            }
        }
        System.out.println(total);
    }
}
