package sprint3;

import java.util.Arrays;

public class Solution {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int [] result = new int [right - left];

        int i = left, j = mid, k = 0;

        while (i < mid && j < right){
            if (arr[i] <= arr[j]){
                result[k] = arr[i];
                i++;
            } else {
                result[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            result[k] = arr[i];   // перенеси оставшиеся элементы left в result
            i++;
            k++;
        }
        while (j < right) {
            result[k] =arr[j];  // перенеси оставшиеся элементы right в result
            j++;
            k++;
        }
        return result;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (right - left < 2){
            return;
        }
        int mid = (left + right)/2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid, right);
        int [] sortedPart = merge(arr, left, mid, right);
        int k = 0;
        for (int i = left; i < right; i++) {
            arr[i] = sortedPart[k];
            k++;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }
}