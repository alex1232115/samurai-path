package sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());

            int[] arrStart = new int[n];

            int[] arrEnd = new int[n];

            for (int i = 0; i < n; i++) {
                String[] line = reader.readLine().split(" ");
                arrStart[i] = Integer.parseInt(line[0]);
                arrEnd[i] = Integer.parseInt(line[1]);
            }
            flowerBedSort(arrStart, arrEnd, n);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void flowerBedSort(int[] arrStart, int[] arrEnd, int n) {
        List<Integer> answerStart = new ArrayList<>();
        List<Integer> answerEnd = new ArrayList<>();
        Arrays.sort(arrStart);
        Arrays.sort(arrEnd);

        if (n > 0) {
            answerStart.add(arrStart[0]);
            answerEnd.add(arrEnd[0]);
        }
        int k = 0;
        for (int i = 1; i < n; i++) {
            if (arrStart[i] <= answerEnd.get(k) && arrEnd[i] > answerEnd.get(k)) {
                answerEnd.set(k, arrEnd[i]);
            } else if (arrStart[i] > answerEnd.get(k)) {
                answerEnd.add(arrEnd[i]);
                answerStart.add(arrStart[i]);
                k++;
            }
        }

        for (int i = 0; i < answerStart.size(); i++) {
            System.out.println(answerStart.get(i) + " " + answerEnd.get(i));
        }
    }
}