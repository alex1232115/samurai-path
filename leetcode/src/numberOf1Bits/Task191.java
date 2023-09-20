package numberOf1Bits;

public class Task191 {
    public static void main(String[] args) {
        System.out.println(new Task191().hammingWeight(0b0000000000000000000000000001011));
    }
    public int hammingWeight(int n) {
        int output = 0;

        while (n!=0){
            output = output + (n&1);
            n = n>>> 1;
        }
        return output;
    }
}
