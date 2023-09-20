package TinkoffFintech;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class D {
    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))){
            char [] arr = rd.readLine().replace(".", "").toCharArray();
            System.out.println(parser(arr));
        } catch (Exception e) {
            System.out.println("WRONG");
        }
    }

    private static int parser(char[] arr) {
        int sum = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            try {
                switch (arr[i]) {
                    case '+':
                        if (stack.isEmpty()){
                            return -1;
                        } else {
                            sum = (stack.pop() - '0') + arr[i+1];
                            stack.add((char)sum);
                        }
                        break;
                    case '-':
                        if (stack.isEmpty()){
                            return -1;
                        } else {
                            sum = (stack.pop() - '0') - arr[i+1];
                            stack.add((char)sum);
                        }
                        break;
                    case '*':
                        if (stack.isEmpty()){
                            return -1;
                        } else {
                            i++;
                            sum = (stack.pop() - '0') * (arr[i] - '0');
                            stack.add((char)sum);
                        }
                        break;
                    case '(': ;
                        int left = i;
                        while (arr[i] != ')'){
                            i++;
                        }
                        stack.add((char) parser(Arrays.copyOfRange(arr, left+1, i)));
                        break;
                    default:
                        stack.add(arr[i]);
                }
            } catch (ArrayIndexOutOfBoundsException e){
                throw new RuntimeException();
            }
        }
        return sum;
    }
}
