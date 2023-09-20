package findallnumbers;

import java.util.*;

public class Task448 {
    public static void main(String[] args) {
        System.out.println(new Task448().findDisappearedNumbers(new int[]{1,1}));
        System.out.println(new Task448().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(new Task448().findDisappearedNumbers(new int[]{10,2,5,10,9,1,1,4,3,7}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(i+1, 0);
        }

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])){
                hashMap.replace(nums[i], hashMap.get(nums[i])+1);
            }
        }

        for (int i = 1; i <= hashMap.size(); i++) {
            if (hashMap.get(i) == 0) list.add(i);
        }
        return list;
    }
}