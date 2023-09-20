package TinkoffContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int q = Integer.parseInt(reader.readLine());
            int [] answer = new int [q];
            for (int i = 0; i < q; i++) {
                StringTokenizer line = new StringTokenizer(reader.readLine());
                int left = Integer.parseInt(line.nextToken());
                int right = Integer.parseInt(line.nextToken());
                answer[i] = prepareDigit(left, right);
            }
            for (int j : answer) {
                System.out.println(j);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int prepareDigit(int left, int right) {
        int current = 1;
        for (int i = left; i < right+1; i++) {
            current*=i;
        }
        while (current > 9){
            current = countDigitSum(current);
        }
        return current;
    }

    private static int countDigitSum(int current) {
        int sum = 0;
        while (current > 0) {
            sum = sum + current % 10;
            current = current / 10;
        }
        return sum;
    }
}
