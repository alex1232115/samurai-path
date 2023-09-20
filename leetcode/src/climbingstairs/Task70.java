package climbingstairs;

public class Task70 {
    public static void main(String[] args) {
        System.out.println(new Task70().climbStairs(45));
    }
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int n1 = 1;
        int n2 = 2;

        for (int i = 3; i < n+1; i++) {
            int a = n1;
            n1 = n2;
            n2 = a + n2;
        }
        return n2;
    }
}
