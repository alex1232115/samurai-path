package singlenumber;

import java.util.Arrays;

// https://leetcode.com/problems/single-number/
public class Task136 {
    public static void main(String[] args) {
        System.out.println(new Task136().singleNumber2(new int [] {4,1,2,1,2}));
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length != 1) {
            for (int i = 0; i < nums.length-1; i+=2) {
                if (nums[i] != nums[i+1]) return nums[i];
            }
        } else return nums[0];
        return nums[nums.length-1];
    }
    public int singleNumber2(int[] nums) {
        int mask = 0;

        for (int i = 0; i < nums.length; i++) {
            mask^=nums[i];
        }
        return mask;
    }
}
