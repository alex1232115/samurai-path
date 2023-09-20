package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class H {
    public static void main(String[] args) {
        String sequence;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            sequence = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(is_correct_bracket_seq_best_solution(sequence));
    }

    private static String is_correct_bracket_seq(String sequence) {
        char[] arr = sequence.toCharArray();

        if (arr.length % 2 != 0) return "False";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];

            if ((current == '[' || current == '{' || current == '(')) {
                stack.push(current);
            } else if ((current == '}' || current == ']' || current == ')') && !stack.isEmpty()) {
                switch (current) {
                    case '}':
                        if (stack.peek() == '{') {
                            stack.pop();
                        } else return "False";
                        break;
                    case ']':
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else return "False";
                        break;
                    case ')':
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else return "False";
                        break;
                }
            } else {
                return "False";
            }
        }
        return "True";
    }

    private static String is_correct_bracket_seq_best_solution(String sequence) {
        char [] arr = sequence.toCharArray();
        Stack <Character> stack = new Stack<>();

        for (char c: arr){
            if (c == '['){
                stack.push(']');
            } else if (c == '{'){
                stack.push('}');
            } else if (c == '('){
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c){
                return "False";
            }
        }
        if (stack.isEmpty()){
            return "True";
        } else {
            return "False";
        }
    }
}