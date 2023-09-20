package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfDays = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        System.out.println(countOfChaosDays(numberOfDays, stringTokenizer));
    }

    private static int countOfChaosDays(int numberOfDays, StringTokenizer stringTokenizer) {
        if (numberOfDays == 1) return 1;

        int [] days = new int [numberOfDays];
        int output = 0;

        for (int i = 0; i < numberOfDays; i++) {
            days[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        if (days[numberOfDays-1] > days[numberOfDays-2]) output++;
        if (days[0] > days[1]) output++;

        for (int i = 1; i < numberOfDays-1; i++) {
            if (days[i] > days[i-1] && days[i] > days[i+1]){
                output++;
            }
        }

        return output;
    }
}
