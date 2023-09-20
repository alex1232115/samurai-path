package ValidParentheses;

import java.util.HashMap;
import java.util.Stack;

public class Task20 {
    public static void main(String[] args) {
        System.out.println(new Task20().isValid("([)]"));
        System.out.println(new Task20().isValid("()"));
        System.out.println(new Task20().isValid("(("));
        System.out.println(new Task20().isValid("(){}}{"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')','(');
        char [] arr = s.toCharArray();

        if (arr.length%2!=0) return false;
        if (arr[0] == ')' || arr[0] == '}' || arr[0] == ']') return false;

        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if ((!stack.empty() && map.get(c) == stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
