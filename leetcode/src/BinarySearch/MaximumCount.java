package BinarySearch;

public class MaximumCount {
    public static void main(String[] args) {
        System.out.println(new MaximumCount().maximumCount(new int [] {-2,-1,-1,1,2,3}));
        System.out.println(new MaximumCount().maximumCount(new int [] {-3,-2,-1,0,0,1,2}));
        System.out.println(new MaximumCount().maximumCount(new int [] {5,20,66,1314}));
        System.out.println(new MaximumCount().maximumCount(new int [] {-1,0,3,5,9,12}));
    }

    public int maximumCount(int[] nums) {
        int neg = bisect_left(nums, 0);
        int pos = nums.length - bisect_left(nums, 1);

        return Math.max(neg, pos);
    }

    private static int bisect_left(int[] nums, int target) {
        int min = 0;
        int max = nums.length-1;

        while (min <= max) {
            int mid = (max + min)/2;

            if (nums[mid] < target) {
                min = mid+1;
            } else{
                max = mid;
            }
        }
        return min;
    }
}
