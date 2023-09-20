package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StackMaxEffective {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StackMaxEffective stack = new StackMaxEffective();
            for (int i = 0; i < n; i++) {
                String currentCommand = reader.readLine();

                if (currentCommand.equals("get_max")){
                    stack.get_max();
                } else if (currentCommand.equals("pop")){
                    stack.pop();
                } else {
                    stack.push(Integer.parseInt(currentCommand.split(" ")[1]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private List<Integer> customStack;

    private List<Integer> listWithMaxElements = new ArrayList<>();
    public StackMaxEffective() {
        this.customStack = new ArrayList<>();
    }

    public void pop() {
        if (customStack.size() == 0) {
            System.out.println("error");
        } else if (listWithMaxElements.get(listWithMaxElements.size()-1).equals(customStack.get(customStack.size()-1))){
            listWithMaxElements.remove(listWithMaxElements.size()-1);
            customStack.remove(customStack.size() - 1);
        } else {
            customStack.remove(customStack.size() - 1);
        }
    }

    public void push(int x) {
        if (listWithMaxElements.size() == 0){
            customStack.add(x);
            listWithMaxElements.add(x);
        } else {
            customStack.add(x);
            if (x >= listWithMaxElements.get(listWithMaxElements.size()-1)){
                listWithMaxElements.add(x);
            }
        }
    }

    public void get_max() {
        if (customStack.size() == 0) {
            System.out.println("None");
        } else {
            System.out.println(listWithMaxElements.get(listWithMaxElements.size()-1));
        }
    }
}
