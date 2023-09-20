package SingleElementInASortedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
        System.out.println(new Main().singleNonDuplicate(new int[] {1}));
    }
    public int singleNonDuplicate(int[] nums) {
        if (nums.length <=1) return nums[0];

        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] !=nums[i+1] && nums[i] != nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
