package missingNumber;

import java.util.Arrays;

public class Task268 {
    public static void main(String[] args) {
        System.out.println(new Task268().missingNumber(new int[]{0, 1}));
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        double arithmeticSum = ((nums[0] + nums[nums.length - 1]) / (double) 2) * (nums.length + 1);

        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
        }
        if (nums.length != nums[nums.length - 1]) {
            return nums.length;
        } else if (nums[0] != 0){
            return 0;
        } else {
            return (int) arithmeticSum - currentSum;
        }
    }
}
