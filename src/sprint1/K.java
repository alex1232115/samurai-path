package sprint1;

import java.io.*;
import java.util.StringTokenizer;

public class K {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(reader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        char[] arr2 = reader.readLine().toCharArray();

        int flag1 = arr.length - 1;
        int flag2 = arr2.length - 1;
        int ost = 0;

        for (int i = 0; i < arr2.length; i++) {
            int sum = arr[flag1 - i] + Integer.parseInt(String.valueOf(arr2[flag2 - i])) + ost;

            arr[flag1 - i] = sum > 9 ? (sum) % 10 : sum;

            ost = sum > 9 ? sum%10 : 0;
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int element: arr){
            writer.write(String.valueOf(element));
            writer.write(" ");
        }
        writer.flush();
    }
}


// 30
//2 0 4 3 3 2 1 8 1 9 6 0 0 1 3 3 8 9 0 8 3 8 6 3 7 9 4 0 2 6
//349