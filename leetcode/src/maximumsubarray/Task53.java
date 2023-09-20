package maximumsubarray;

public class Task53 {
    public static void main(String[] args) {

        System.out.println(new Task53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {

        int sum = 0;
        int output = nums[0];
        int negative = 0;

        for (int i = 0; i < nums.length; i++){

            if (nums[i]>=0){
                sum = Math.max(nums[i], negative + sum + nums[i]);
            } else {
                negative = nums[i];
            }
        }

        return Math.max(output, sum);
    }
}


// for (int i = 0; i < nums.length-1; i++) {
//        if (nums[i] >= 0){
//        sum+=nums[i];
//        } else if (nums[i] + sum + nums[i+1] >= sum) {
//        i++;
//        sum+=nums[i] + nums[i+1];
//        } else {
//        output = Math.max(output,sum);
//        sum = 0;
//        }


//        for (int i = 0; i < nums.length-1; i++) {
//        if (nums[i] >= 0){
//        sum+=nums[i];
//        } else { //отрицательное число
//        if (nums[i+1] > sum + nums[i] && sum <= nums[i+1]){
//        sum = nums[i+1];
//        i++;
//        } else if (nums[i] + nums[i+1] >=0){
//        sum+=nums[i+1] + nums[i];
//        i++;
//        }
//        else {
//        output = Math.max(output, sum);
//        sum = 0;
//        }
//        }
//        }


//for (int i = 0; i < nums.length; i++) {
//        //положительное число
//        if (nums[i] >= 0) {
//        sum += nums[i];
//        } else { //число отрицательное
//        //следующее больше текущего и предыдущего
//        if (nums[i+1] > sum+nums[i]) {
//        output = Math.max(output, sum);
//        sum = 0;
//        continue;
//        }
//        //сумма текущего, всех предыдущих и следующего больше больше предыдущей суммы
//        if (sum + nums[i] + nums[i+1] >= sum) {
//        sum+=nums[i];
//        } else { //число не подходит не под одно из условий
//        output = Math.max(output, sum);
//        sum = 0;
//        }
//        }
//        }