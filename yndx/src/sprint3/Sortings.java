package sprint3;

import java.util.Arrays;

public class Sortings {
    public static void main(String[] args) {
        bubbleSort(new int[]{5, 3, 76, -5, 0, 1, 1, 1});
        System.out.println("Merge Sort:");
        System.out.println(Arrays.toString(mergeSort(new int[]{5, 3, 76, -5, 0, 1, 1, 1}))); // O(log(n)*n)
        insertionSort(new int[]{5, 3, 76, -5, 0, 1, 1, 1}); // O(n^2)
        System.out.println("Quick Sort:");
        int [] arrQuick = new int []{5, 3, 76, -5, 0, 1, 1, 1};
        quickSort(arrQuick, 0 , 7); // O(log(n)*n)
        System.out.println(Arrays.toString(arrQuick));
        selectionSort(new int[]{5, 3, 76, -5, 0, 1, 1, 1}); // O(n^2)
        //Сортировка подсчёт, только для случая, когда известен диапазон чисел O(n)
        countingSort(new int []{5, 3, 76, 0, 0, 734, 1, 99}, 735);
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Bubble Sort:");
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minElementIndex] > arr[j]) {
                    minElementIndex = j;
                }
            }
            if (minElementIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minElementIndex];
                arr[minElementIndex] = temp;
            }
        }
        System.out.println("Selection Sort:");
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int item_to_insert = arr[i];
            int j = i;
            while (j > 0 && item_to_insert < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = item_to_insert;
        }
        System.out.println("Insertion Sort:");
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0 || low >=high)
            return;

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    private static int [] mergeSort(int[] arr) {
        if (arr.length == 1) {  // базовый случай рекурсии
            return arr;
        }

        // запускаем сортировку рекурсивно на левой половине
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, arr.length/2));

        // запускаем сортировку рекурсивно на правой половине
        int[] right = mergeSort(Arrays.copyOfRange(arr, arr.length/2, arr.length));

        // заводим массив для результата сортировки
        int[] result = new int[arr.length];

        // сливаем результаты
        int l = 0, r = 0, k = 0;
        while (l < left.length && r < right.length) {
            // выбираем, из какого массива забрать минимальный элемент
            if (left[l] <= right[r]) {
                result[k] = left[l];
                l++;
            } else {
                result[k] = right[r];
                r++;
            }
            k++;
        }

        // Если один массив закончился раньше, чем второй, то
        // переносим оставшиеся элементы второго массива в результирующий
        while (l < left.length) {
            result[k] = left[l];   // перенеси оставшиеся элементы left в result
            l++;
            k++;
        }
        while (r < right.length) {
            result[k] = right[r];  // перенеси оставшиеся элементы right в result
            r++;
            k++;
        }
        return result;
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
        System.out.println(Arrays.toString(array));
        return array;
    }
}
