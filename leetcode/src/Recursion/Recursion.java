package Recursion;

public class Recursion {
    public static void main(String[] args) {
//        System.out.println(factorial(5));
        System.out.println(factorial2(5,0));
    }
    public static int factorial(int x){
        if (x==1){
            return 1;
        }else{
            return x* factorial(x-1);
        }
    }

    public static int factorial2(int x, int running_total){
        if (x==0){
            return running_total;
        }else{
            return factorial2(x-1, running_total + x);
        }
    }
}
