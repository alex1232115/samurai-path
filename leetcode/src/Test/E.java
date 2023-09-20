package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E {

    // Если ответ существует, верните список из двух элементов
    // Если нет - то верните пустой список 
    private static List<Integer> twoSum(List<Integer> arr, int targetSum) {
        int n1 = 0;
        int n2 = arr.size() - 1;

        ArrayList<Integer> list = new ArrayList<>();

        while (n1 < n2) {
            if (arr.get(n1) + arr.get(n2) == targetSum) {
                list.add(arr.get(n1));
                list.add(arr.get(n2));
                return list;
            } else if (arr.get(n1) + arr.get(n2) > targetSum) {
                n2--;
            } else if (arr.get(n1) + arr.get(n2) < targetSum) {
                n1++;
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int targetSum = readInt(reader);
            List<Integer> result = twoSum(arr, targetSum);
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(result.get(0) + " " + result.get(1));
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem)).sorted()
                .collect(Collectors.toList());
    }

}