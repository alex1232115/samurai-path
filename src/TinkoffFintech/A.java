package TinkoffFintech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))){
            int input = Integer.parseInt(rd.readLine());
            if (input == 1){
                System.out.println(1);
            } else if (input == 2){
                System.out.println(4);
            } else {
                int sum = 4;
                for (int i = 2; i < input; i++) {
                    sum += 4;
                }
                System.out.println(sum);
            }
        }
    }
}
