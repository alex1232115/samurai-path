package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class I {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());

        System.out.println(check(input));
    }

    private static String check(int input) {
        if (input == 1) return "True";

        int current = 4;
        while (current <= input){
            if (current == input) return "True";
            current*=4;
        }

        return "False";
    }
}
