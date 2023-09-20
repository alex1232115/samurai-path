package countingbites;

import java.util.Arrays;

public class Task338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Task338().countBits(5)));
    }

    public int[] countBits(int n) {
        int [] ans = new int [n+1];
        ans[0] = 0;

        for (int i = 1; i <= n; i ++){
            if (i%2 == 0){
                ans[i] = ans[i/2];
            } else {
                ans[i] = ans[i/2] + 1;
            }
        }
        return ans;
    }
}
