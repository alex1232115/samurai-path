package Test;

public class Fib {
    public static void main(String[] args) {
        Sequence(50);
    }

    public static void Sequence(int N){
        if (N > 50 || N <1) return;

        int n = N;
        Long t1 = 0l, t2 = 1l;
        for (int i = 1; i <= n; ++i) {
            System.out.println(t1 + " ");
            Long sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
    }
}
