package Selection_sort;

import java.util.Arrays;

public class Selection_sort {
    public static void main(String[] args) {
        selectionSort(new int[] {5,3,6,2,10});
    }
    public static int findSmallest(int [] arr){
        int smallest = arr[0];
        int smallestIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest){
                smallest = arr[i];
                smallestIndex = i;
            }
        }
        return  smallestIndex;
    }

    public static void selectionSort(int [] arr){
        int [] newArr = new int [arr.length];
        int smallest;
        for (int i = 0; i < arr.length; i++) {
            smallest = findSmallest(arr);
            newArr[i] = arr[smallest];
            arr[smallest] = Integer.MAX_VALUE;
        }
        System.out.println(Arrays.toString(newArr));
    }
}
