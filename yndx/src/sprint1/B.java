package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        boolean previousFlag = Integer.parseInt(tokenizer.nextToken())%2==0;
        String output = "WIN";
        for (int i = 1; i < 3; i++) {
            int currentNumber = Integer.parseInt(tokenizer.nextToken());
            boolean currentFlag = currentNumber%2==0;
            if (currentFlag !=previousFlag){
                output = "FAIL";
                break;
            }
        }
        System.out.println(output);
    }
}
