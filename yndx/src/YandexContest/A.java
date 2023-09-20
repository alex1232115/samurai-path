package YandexContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            HashMap<Integer, Integer> symbolsRows = new HashMap<>();
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer symbolsTokenizer = new StringTokenizer(reader.readLine());
            StringTokenizer rowsTokenizer = new StringTokenizer(reader.readLine());

            for (int i = 0; i < n; i++) {
                symbolsRows.put(Integer.parseInt(symbolsTokenizer.nextToken()), Integer.parseInt(rowsTokenizer.nextToken()));
            }
            int k = Integer.parseInt(reader.readLine());
            int [] reportSymbols =  new int [k];
            StringTokenizer reportSymbolsTokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < k; i++) {
                reportSymbols[i] = Integer.parseInt(reportSymbolsTokenizer.nextToken());
            }
            System.out.println(digitCapacity(symbolsRows, reportSymbols));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int digitCapacity(HashMap<Integer, Integer> symbolsRows, int[] reportSymbols) {
        if (symbolsRows.size() == 0 || reportSymbols.length == 0){
            return 0;
        }

        int output = 0;
        for (int i = 1; i < reportSymbols.length; i++) {
            if (!Objects.equals(symbolsRows.get(reportSymbols[i]), symbolsRows.get(reportSymbols[i - 1]))){
                output++;
            }
        }
        return output;
    }
}
