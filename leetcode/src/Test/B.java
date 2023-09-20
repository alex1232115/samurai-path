package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            list.add(arr1[i]);
            list.add(arr2[i]);
        }

    }
}
