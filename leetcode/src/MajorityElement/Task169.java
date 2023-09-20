package MajorityElement;

import java.util.HashMap;

public class Task169 {
    public static void main(String[] args) {
        System.out.println(new Task169().majorityElement(new int[] {1}));
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int major = nums.length/2;

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])){
                hashMap.replace(nums[i], (hashMap.get(nums[i]))+1);
            } else {
                hashMap.put(nums[i], 1);
            }
            if (hashMap.get(nums[i]) > major){
                return nums[i];
            }
        }
        return -1;
    }
}
