package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class StackMax {

    public static void main(String[] args) {
        StackMax stackMax = new StackMax();
        int n;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                String currentCommand = reader.readLine();
                switch (currentCommand) {
                    case "get_max": {
                        stackMax.get_max();
                        break;
                    }
                    case "pop": {
                        stackMax.pop();
                        break;
                    }
                    default:
                        stackMax.push(Integer.parseInt(currentCommand.split(" ")[1]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Integer> customStack;

    public StackMax() {
        this.customStack = new LinkedList<>();
    }

    public void pop() {
        if (customStack.size() == 0) {
            System.out.println("error");
        } else {
            customStack.remove(customStack.size() - 1);
        }
    }

    public void push(int x) {
        customStack.add(x);
    }

    public void get_max() {
        if (customStack.size() == 0) {
            System.out.println("None");
        } else {
            int maxDigit = customStack.get(0);
            for (int i = 0; i < customStack.size(); i++) {
                if (customStack.get(i) > maxDigit) {
                    maxDigit = customStack.get(i);
                }
            }
            System.out.println(maxDigit);
        }
    }
}
