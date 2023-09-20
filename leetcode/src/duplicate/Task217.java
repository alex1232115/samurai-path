package duplicate;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Task217 {
    public static void main(String[] args) {
        System.out.println(new Task217().containsDuplicate(new int[] {1,2,3,4}));
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            if (hashMap.containsKey(num)){
                return true;
            } else {
                hashMap.put(num, 1);
            }
        }
        return false;
    }
}
