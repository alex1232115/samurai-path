package YndxContest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    private static int balance(List<Integer> arr, int n) {

        int max = arr.get(n-1);
        int min = 0;

        if (arr.size()==1) return 0;

        for (int i = n-1; i >= 1; i--) {
            if (arr.get(i) >= arr.get(i-1)){
                min = arr.get(i-1);
            } else {
                return -1;
            }
        }
        return max-min;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);

            int result = balance(arr, n);

            System.out.println(result);
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