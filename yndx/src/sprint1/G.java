package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        System.out.println(binaryTranslate(number));
    }

    private static StringBuilder binaryTranslate(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        if (number == 0) return stringBuilder.append(0);
        while(number/2!=0){
            stringBuilder.append(number%2);
            number = number/2;
        }
        stringBuilder.append(1);
        return stringBuilder.reverse();
    }
}
