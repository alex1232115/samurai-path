package TinkoffFintech;

import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer sk = new StringTokenizer(rd.readLine());
            int columns = Integer.parseInt(sk.nextToken());
            int lines = Integer.parseInt(sk.nextToken());
            int [][] arr = new int[lines][columns];
            int count = 1;
            for (int i = 0; i < columns * lines; i++) {
                for (int j = 0; j < i; j++) {
                    try {
                        arr[j][i - j - 1] = count;
                        count++;
                    } catch (ArrayIndexOutOfBoundsException e){
                        continue;
                    }
                }
            }
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    wt.write(String.valueOf(anInt));
                    wt.write(" ");
                }
                wt.newLine();
            }
        }
    }
}
