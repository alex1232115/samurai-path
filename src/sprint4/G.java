package sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class G {
    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(rd.readLine()); // количество раундов.
            Map<Integer, Integer> rounds = new HashMap<>(); //сумма раундов - длина
            int sum = 0;
            int maxLength = 0;
            char [] arr = rd.readLine().replace(" ", "").toCharArray();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '0'){
                    sum--;
                } else {
                    sum++;
                }
                if (sum == 0){
                    maxLength = i+1;
                } else if (rounds.containsKey(sum)){
                    maxLength = Math.max(maxLength, i - rounds.get(sum));
                } else {
                    rounds.put(sum, i);
                }
            }
            System.out.println(maxLength);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}