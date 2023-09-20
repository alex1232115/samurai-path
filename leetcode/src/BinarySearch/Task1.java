package BinarySearch;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(new Task1().search(new int[]{-1,0,3,5,9,12}, 12));
        System.out.println(new Task1().search(new int[]{-1,0,3,5,9,12}, -1));
        System.out.println(new Task1().search(new int[]{-1,0,3,5,9,12}, 0));
        System.out.println(new Task1().search(new int[]{-1,0,3,5,9,12}, 3));
        System.out.println(new Task1().search(new int[]{-1,0,3,5,9,12}, 123));
    }

    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length-1;

        while(min<=max){
            int mid = (min + max)/2;
            int current = nums[mid];

            if (current == target){
                return mid;
            } else if (current > target){
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return -1;
    }
}
