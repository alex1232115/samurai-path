package sprint2;

import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {

        int[][] newArr;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int m = Integer.parseInt(bufferedReader.readLine());

            newArr = new int[m][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < m; j++) {
                    newArr[j][i] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int[] arr : newArr) {
                for (int i = 0; i < arr.length; i++) {
                    writer.write(arr[i] + " ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
