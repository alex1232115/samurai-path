package sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class F {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(reader.readLine());
            int [] cutNumber = new int [n];

            StringTokenizer line = new StringTokenizer(reader.readLine());
            for (int i = 0; i < cutNumber.length; i++) {
                cutNumber[i] = Integer.parseInt(line.nextToken());
            }
            perimeterRectangle(cutNumber);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void perimeterRectangle(int[] cutNumber) {
        Arrays.sort(cutNumber);
        int maxSum = 0;
        int first = cutNumber.length-1, second = first-1, third = second-1;
        for (int i = cutNumber.length-1; i >= 2; i--) {
            if (cutNumber[first] < cutNumber[second] + cutNumber[third]){
                maxSum = cutNumber[first] + cutNumber[second] + cutNumber[third];
                break;
            } else {
                first--;
                second--;
                third--;
            }
        }
        System.out.println(maxSum);
    }
}
