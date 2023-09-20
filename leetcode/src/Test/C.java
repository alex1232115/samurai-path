package Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C {

    private static List<Double> movingAverage(int n, List<Integer> arr, int windowSize) {
        List<Double> output = new ArrayList<>();

        double current_sum = 0;

        for (int i = 0; i < windowSize; i++) {
            current_sum+=arr.get(i);
        }

        output.add(0, current_sum/windowSize);

        for (int i = 0; i < arr.size()-windowSize; i++) {
            current_sum -=arr.get(i);
            current_sum+= arr.get(i+windowSize);

            output.add(current_sum/windowSize);
        }

        return output;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int windowSize = readInt(reader);
            List<Double> result = movingAverage(n, arr, windowSize);
            for (double elem : result) {
                writer.write(elem + " ");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }
}