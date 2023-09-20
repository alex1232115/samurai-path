package sprint3;

import java.io.*;
import java.util.StringTokenizer;

public class L {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int days = Integer.parseInt(reader.readLine());

            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int[] capitals = new int[days];
            for (int i = 0; i < days; i++) {
                capitals[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            int priceOnBike = Integer.parseInt(reader.readLine());

            int firstOutput = findDay(capitals, priceOnBike, 0, days - 1);
            writer.write(String.valueOf(firstOutput));
            writer.write(" ");
            writer.write(String.valueOf(findDay(capitals, priceOnBike * 2, firstOutput, days)));
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findDay(int[] capitals, int priceOnBike, int left, int right) {
        if (right <= left) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (priceOnBike <= capitals[mid]) {
            if ((mid != 0) && (capitals[mid-1] >= priceOnBike)){
                return findDay(capitals, priceOnBike, left, mid);
            } else {
                return mid + 1;
            }
        } else {
            return findDay(capitals, priceOnBike, mid + 1, right);
        }
    }
}