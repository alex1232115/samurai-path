package grokaem_algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Chapter4 {
    public static void main(String[] args) {
        int [] arr = new int [] {2,4,6,-1,25,0,0};
        System.out.println(sum(arr));

        System.out.println(count(arr));

        System.out.println(findMax(arr));
    }

    public static int sum(int [] arr){
        if (arr.length==1) return arr[0];
        if (arr.length==0) return 0;

        int [] newArr = new int [arr.length-1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i+1];
        }
        return arr[0] +sum(newArr);
    }

    public static int count(int [] arr){
        if (arr.length == 1) return 1;
        int [] arr2 = new int[arr.length-1];
        return count(arr2) + 1;
    }

    public static int findMax(int [] arr) {
        int a;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]){
                a = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = a;
            }
        }
        return arr[arr.length-1];
    }
}
