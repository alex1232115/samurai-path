package TinkoffContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(reader.readLine());
            costShumerid(n);
        }
    }

    private static void costShumerid(int n) {
        int [] arr = new int [n];
        int volume = 1;
        for (int i = 2; i <= n; i++) {
            volume = volume + (i * 2 - 1) * (i * 2 - 1);
            arr[i-1] = (2*i-1)*(2*i-1)*(2*i-1) - volume;
        }

        for (int i: arr){
            System.out.print(i + " ");
        }
    }
}
