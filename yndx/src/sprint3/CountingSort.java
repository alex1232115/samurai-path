package sprint3;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countingSort(new int[]{12,6,3,87,123,43,5,2,5,8,77,69,25}, 124)));
    }
    public static int[] countingSort(int[] array, int k) {
        int[] countedValues = new int[k];
        for (int value : array) {
            countedValues[value]++;
        }

        int index = 0;
        for (int value = 0; value < k; value++) {
            for (int amount = 0; amount < countedValues[value]; amount++) {
                array[index] = value;
                index++;
            }
        }
        return array;
    }
}
