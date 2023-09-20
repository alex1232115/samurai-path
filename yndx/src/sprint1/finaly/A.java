package sprint1.finaly;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//86089956
public class A {
    public static void main(String[] args) {
        int streetLength;
        StringTokenizer stringTokenizer;
        //1
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            streetLength = Integer.parseInt(reader.readLine());
            stringTokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int[] housesNumbers = new int[streetLength];
        //2
        List<Integer> lengthOfZeroHouse = new ArrayList<>();

        for (int i = 0; i < streetLength; i++) {
            housesNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (housesNumbers[i] == 0) {
                lengthOfZeroHouse.add(i);
            }
        }
        nearestEmptyHouse(streetLength, housesNumbers, lengthOfZeroHouse);
    }

    private static void nearestEmptyHouse(int streetLength, int[] arr, List<Integer> lengthOfZeroHouse) {
        int[] outputLengths = new int[streetLength];

        int previousLengthZeroHouse = lengthOfZeroHouse.get(0);
        int count = 0;
        //идем в ---> сторону
        for (int i = 0; i < streetLength; i++) {
            if (arr[i] == 0) {
                outputLengths[i] = 0;
                previousLengthZeroHouse = lengthOfZeroHouse.get(count);
                count++;
            } else {
                outputLengths[i] = (Math.abs(i - previousLengthZeroHouse));
            }
        }
        previousLengthZeroHouse = lengthOfZeroHouse.get(lengthOfZeroHouse.size() - 1);
        count = lengthOfZeroHouse.size() - 1;
        //идем в <--- сторону
        for (int i = streetLength - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                outputLengths[i] = 0;
                previousLengthZeroHouse = lengthOfZeroHouse.get(count);
                count--;
            } else {
                outputLengths[i] = Math.min(Math.abs(i - previousLengthZeroHouse), outputLengths[i]);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i : outputLengths) {
                writer.write(String.valueOf(i));
                writer.write(" ");
            }
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}